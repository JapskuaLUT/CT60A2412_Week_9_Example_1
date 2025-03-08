package com.example.week9example1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week9example1.model.Product;
import com.example.week9example1.repository.ProductRepository;
import com.example.week9example1.repository.RemoteProductRepository;
import com.example.week9example1.ui.CheckoutActivity;
import com.example.week9example1.ui.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle edge-to-edge display
        // We need to use the root view of the layout instead of a specific ID
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize repository
        productRepository = new RemoteProductRepository();

        // Setup UI
        setupRecyclerView();
        setupCheckoutButton();
        loadProducts();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize with empty list, will be populated later
        adapter = new ProductAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(adapter);
    }

    private void setupCheckoutButton() {
        findViewById(R.id.checkout_button).setOnClickListener(v -> {
            Intent intent = new Intent(this, CheckoutActivity.class);
            startActivity(intent);
        });
    }

    private void loadProducts() {
        // In a real app, this would be done asynchronously with a background thread
        // Using AsyncTask is now deprecated, but shown here for educational purposes:
        /*
        new AsyncTask<Void, Void, List<Product>>() {
            @Override
            protected List<Product> doInBackground(Void... voids) {
                return productRepository.getAllProducts();
            }

            @Override
            protected void onPostExecute(List<Product> products) {
                updateUI(products);
            }
        }.execute();
        */

        // Modern approach would use Kotlin coroutines, Java CompletableFuture,
        // or libraries like RxJava, but that's beyond the scope of this example

        // For demo purposes, create some sample products
        List<Product> products = createSampleProducts();
        updateUI(products);
    }

    private void updateUI(List<Product> products) {
        // Update the adapter with the products
        adapter = new ProductAdapter(this, products);
        recyclerView.setAdapter(adapter);
    }

    private List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Smartphone", "Latest model smartphone with high-resolution camera and long battery life", 699.99, "url_to_image"));
        products.add(new Product("2", "Laptop", "Powerful laptop with fast processor and ample storage for all your needs", 1299.99, "url_to_image"));
        products.add(new Product("3", "Headphones", "Noise cancelling headphones with premium sound quality", 199.99, "url_to_image"));
        products.add(new Product("4", "Smartwatch", "Track your fitness and stay connected with this premium smartwatch", 249.99, "url_to_image"));
        products.add(new Product("5", "Tablet", "Lightweight tablet perfect for entertainment and productivity", 399.99, "url_to_image"));
        return products;
    }
}