package edu.miu.cs489.project.webshop.service;

import edu.miu.cs489.project.webshop.ComponentTest;
import edu.miu.cs489.project.webshop.exception.ProductNotFoundException;
import edu.miu.cs489.project.webshop.model.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ProductServiceIntegrationTest extends ComponentTest {
    @Autowired
    private ProductService productService;
    @BeforeEach
    void setUp() {
        logger.info("PatientServiceImpIntegrationTest started");
    }
    @AfterEach
    void tearDown() {
        logger.info("PatientServiceImpIntegrationTest completed");
    }
    @Test
    void getExistingProductByIdWithIntegrationTest() throws ProductNotFoundException {
        Integer productId = 1;
        Product foundedProduct = productService.getProductById(productId);
        assertNotNull(foundedProduct);
        assertEquals(productId, foundedProduct.getProductId());
    }

    @Test
    void getNonExistingProductIdWithIntegrationTest() {
        Integer productId = 0;
        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(productId);
        });
    }
}