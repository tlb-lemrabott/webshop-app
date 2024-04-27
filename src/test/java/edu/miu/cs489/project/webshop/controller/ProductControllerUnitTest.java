package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.model.Product;
import edu.miu.cs489.project.webshop.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc
class ProductControllerUnitTest {
    @InjectMocks
    private ProductController productController;
    @MockBean
    private ProductService productService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void getAllProductsMockTest() throws Exception{
        List<Product> products = Arrays.asList(
                new Product(1, "Smartphone", "ABC Electronics", "Japan", 599.99, 100, "A high-quality smartphone with advanced features."),
                new Product(2, "iPhone", "Smartphones", "Taiwan", 345.99, 10, "A high-quality smartphone with advanced features."),
                new Product(3, "ThinkPad Lenovo T470", "Computers", "China", 999.99, 30, "A high-quality smartphone with advanced features.")
        );
        Mockito.when(productService.getAllProducts()).thenReturn(products);
        ResponseEntity<List<Product>> responseEntity = productController.getAllProducts();

        verify(productService, times(1)).getAllProducts();

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Product> responseBody = responseEntity.getBody();
        Assertions.assertEquals(3, responseBody.size());
    }
}