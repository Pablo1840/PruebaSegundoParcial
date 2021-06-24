package com.pablo.salazar.Api.resources;

import com.pablo.salazar.Api.entities.Producto;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ProductoResourceTest {

    @Autowired
    private RestService restService;
    private Producto producto;

    @Test
    public void getAllProduct() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductoResource.PRODUCTO).get().build();
        System.out.println(json);
    }

    @Test
    public void getById() {
        String json = restService
                .restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(ProductoResource.PRODUCTO).path(ProductoResource.ID).expand(10).get().build();
        System.out.println(json);
    }
}