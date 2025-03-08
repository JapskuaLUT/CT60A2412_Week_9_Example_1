package com.example.week9example1.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week9example1.R;
import com.example.week9example1.model.Product;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> products;
    private Context context;

    public ProductAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create view holder
        // Note: Ensure item_product.xml exists in res/layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Bind product data to view
        Product product = products.get(position);

        // Make sure we don't call setText on null TextViews
        if (holder.nameTextView != null) {
            holder.nameTextView.setText(product.getName());
        }

        if (holder.priceTextView != null) {
            holder.priceTextView.setText("$" + product.getPrice());
        }

        if (holder.descriptionTextView != null) {
            holder.descriptionTextView.setText(product.getDescription());
        }

        // In a real app, we would load the image using Glide or Picasso
        // Glide.with(context).load(product.getImageUrl()).into(holder.productImageView);

        // Set up add to cart button if it exists
        if (holder.addToCartButton != null) {
            holder.addToCartButton.setOnClickListener(v -> {
                // In a real app, add the product to the cart
                // For demonstration, just show a toast
                // Toast.makeText(context, product.getName() + " added to cart", Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView priceTextView;
        public TextView descriptionTextView;
        public ImageView productImageView;
        public Button addToCartButton;

        public ViewHolder(View itemView) {
            super(itemView);
            // Find all the views by their IDs
            nameTextView = itemView.findViewById(R.id.product_name);
            priceTextView = itemView.findViewById(R.id.product_price);
            descriptionTextView = itemView.findViewById(R.id.product_description);
            productImageView = itemView.findViewById(R.id.product_image);
            addToCartButton = itemView.findViewById(R.id.add_to_cart_button);
        }
    }
}