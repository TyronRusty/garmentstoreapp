package org.perscholas.app.service;
import org.perscholas.app.models.Product;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.app.controller.ImageController;
import org.perscholas.app.dao.ImageRepoI;
import org.perscholas.app.dao.ProductRepoI;
import org.perscholas.app.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Slf4j
@Service
public class ImageService {

    private final Path root = Paths.get("./uploads");
    ProductRepoI productRepoI;
    ProductService productService;
    ImageRepoI imageRepoI;

    @Autowired
    public ImageService(ProductRepoI productRepoI, ProductService productService, ImageRepoI imageRepoI) {
        this.productRepoI = productRepoI;
        this.productService = productService;
        this.imageRepoI = imageRepoI;
    }
    public void init() throws Exception {
        try {
            if(Files.exists(root)){
                log.debug("Folder Exists!");
            }else {
                Files.createDirectories(root);
                log.debug("Folder Created!");
            }
        } catch (IOException e) {
            throw new Exception("Could not initialize folder for upload!");
        }
    }

    public void save(MultipartFile file, String productName) throws Exception {
        try {
            Product product = productRepoI.findByproductName(productName).get();
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            log.debug(ext);
            String imageName = productName.split("@")[0].concat("-").concat(String.valueOf(LocalDate.now().getYear())).concat(ext);
            log.debug(imageName);
            Files.copy(file.getInputStream(), this.root.resolve(imageName));
            Path p = root.resolve(imageName);
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getImage", p.getFileName().toString()).build().toString();
            log.debug(url);
            Image image = new Image();
            image.setUrl(url);
        image.setName(imageName);
            image.setProduct(product);
            imageRepoI.save(image);


        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new Exception("A file of that name already exists.");
            } else {
                throw new Exception("Error copying file to HD" + file.getOriginalFilename());
            }

        }
    }

    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = (Resource) new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
