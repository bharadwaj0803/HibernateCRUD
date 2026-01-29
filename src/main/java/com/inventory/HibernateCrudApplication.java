package com.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inventory.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class HibernateCrudApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        entityManager.persist(new Product("Pen","Stationery",10,50));
        entityManager.persist(new Product("Notebook","Stationery",60,25));
        entityManager.persist(new Product("Marker","Stationery",40,10));
        entityManager.persist(new Product("Bag","Accessories",1200,5));
        entityManager.persist(new Product("Bottle","Accessories",300,15));
        entityManager.persist(new Product("Laptop","Electronics",55000,3));

        System.out.println("Products inserted successfully!");
    }
}
