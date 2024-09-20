package com.GeT.commerce.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private double price;

    @Column(name="category")
    private String category;

    @Column(name="description")
    private String description;

    @Column(name="quantity_in_stock")
    private int quantityInStock;

    @Column(name="brand_id")
    private String brandId;

    @Column(name="image_urls")
    private String imageUrl;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="status")
    private boolean status;

    @Column(name="discount")
    private int discount;

    @Column(name="weight")
    private double weight;

    @Column(name="dimensions")
    private String dimensions;

    @Column(name="color")
    private String color;

    @Column(name="size")
    private String size;

    @Column(name="material")
    private String material;

    @Column(name="tags")
    private String tags;

    @Column(name="featured")
    private boolean featured;

    @Column(name="is_new")
    private boolean isNew;

    @Column(name="shipping_details")
    private String shippingDetails;

    public Product() {
    }

    public Product(int id, String title, double price, String category, String description, int quantityInStock, String imageUrl, String brandId, LocalDateTime createdAt, LocalDateTime updatedAt, boolean status, int discount, double weight, String dimensions, String color, String size, String material, String tags, boolean featured, boolean isNew, String shippingDetails) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.imageUrl = imageUrl;
        this.brandId = brandId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.discount = discount;
        this.weight = weight;
        this.dimensions = dimensions;
        this.color = color;
        this.size = size;
        this.material = material;
        this.tags = tags;
        this.featured = featured;
        this.isNew = isNew;
        this.shippingDetails = shippingDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(String shippingDetails) {
        this.shippingDetails = shippingDetails;
    }
}
