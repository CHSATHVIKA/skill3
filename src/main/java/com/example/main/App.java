package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.util.HibernateUtil;
import com.example.loader.ProductDataLoader;
import com.example.demo.HQLDemo;  // Import your HQLDemo class

public class App {

    public static void main(String[] args) {
        // Get SessionFactory from HibernateUtil
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        try {
            // -------------------------------
            // Task 2: Load sample products (run once)
            // -------------------------------
            // Uncomment only once to add sample data
            // ProductDataLoader.loadSampleProducts(session);

            // -------------------------------
            // Task 3: Sorting
            // -------------------------------
            HQLDemo.sortProductsByPriceAscending(session);
            HQLDemo.sortProductsByPriceDescending(session);
            HQLDemo.sortProductsByQuantityDescending(session);

            // -------------------------------
            // Task 5: Pagination
            // -------------------------------
            HQLDemo.getFirstThreeProducts(session);
            HQLDemo.getNextThreeProducts(session);
            // Or generic pagination example:
            // HQLDemo.getPaginatedProducts(session, 1, 3);

            // -------------------------------
            // Task 6: Aggregate operations
            // -------------------------------
            HQLDemo.countTotalProducts(session);
            HQLDemo.countProductsInStock(session);
            HQLDemo.countProductsByDescription(session);
            HQLDemo.findMinMaxPrice(session);

            // -------------------------------
            // Task 7: Group By
            // -------------------------------
            HQLDemo.groupProductsByDescription(session);
            HQLDemo.groupProductsWithAggregation(session);

            // -------------------------------
            // Task 8: Filter by price range
            // -------------------------------
            HQLDemo.filterProductsByPriceRange(session, 20.0, 100.0);

            // -------------------------------
            // Task 9: LIKE pattern queries
            // -------------------------------
            HQLDemo.findProductsStartingWith(session, "D");   // names starting with D
            HQLDemo.findProductsEndingWith(session, "p");     // names ending with p
            HQLDemo.findProductsContaining(session, "Desk");  // names containing "Desk"
            HQLDemo.findProductsByNameLength(session, 5);     // names of length 5

        } finally {
            // Always close session and factory
            session.close();
            factory.close();
        }
    }
}