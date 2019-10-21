
package com.mac.testdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("product_id")
    @Expose
    public Integer productId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("cat_id")
    @Expose
    public Integer catId;
    @SerializedName("sides")
    @Expose
    public String sides;
    @SerializedName("size")
    @Expose
    public String size;
    @SerializedName("sku")
    @Expose
    public String sku;
    @SerializedName("opening_qty")
    @Expose
    public Integer openingQty;
    @SerializedName("weight_type")
    @Expose
    public Integer weightType;
    @SerializedName("material")
    @Expose
    public String material;
    @SerializedName("m_composition")
    @Expose
    public String mComposition;
    @SerializedName("m_unit")
    @Expose
    public String mUnit;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("banner_path")
    @Expose
    public String bannerPath;
    @SerializedName("created")
    @Expose
    public String created;
    @SerializedName("last_updated")
    @Expose
    public String lastUpdated;
    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("category_name")
    @Expose
    public String categoryName;
    @SerializedName("size_name")
    @Expose
    public String sizeName;
    @SerializedName("material_name")
    @Expose
    public String materialName;

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Integer getCatId() {
        return catId;
    }

    public String getSides() {
        return sides;
    }

    public String getSize() {
        return size;
    }

    public String getSku() {
        return sku;
    }

    public Integer getOpeningQty() {
        return openingQty;
    }

    public Integer getWeightType() {
        return weightType;
    }

    public String getMaterial() {
        return material;
    }

    public String getmComposition() {
        return mComposition;
    }

    public String getmUnit() {
        return mUnit;
    }

    public String getDescription() {
        return description;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public String getCreated() {
        return created;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public String getMaterialName() {
        return materialName;
    }
}
