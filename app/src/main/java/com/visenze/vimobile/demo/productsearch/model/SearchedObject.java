/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2019 ViSenze Pte. Ltd.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package com.visenze.vimobile.demo.productsearch.model;

import android.content.res.Resources;
import android.graphics.Bitmap;

import com.visenze.vimobile.demo.R;
import com.visenze.vimobile.demo.objectdetection.model.DetectedObject;
import com.visenze.vimobile.demo.utils.ImageUtils;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * Hosts the detected object info and its search result.
 */
public class SearchedObject {

    private final DetectedObject object;
    private final List<Product> productList;
    private final int objectThumbnailCornerRadius;

    @Nullable
    private Bitmap objectThumbnail;

    public SearchedObject(Resources resources, DetectedObject object, List<Product> productList) {
        this.object = object;
        this.productList = productList;
        this.objectThumbnailCornerRadius =
                resources.getDimensionPixelOffset(R.dimen.bounding_box_corner_radius);
    }

    public int getObjectIndex() {
        return object.getObjectIndex();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public synchronized Bitmap getFixSizeThumbnail(int width, int height) {

        if (objectThumbnail == null) {
            objectThumbnail = ImageUtils.getFixSizeRoundCornerBitmap(object.getSquaredThumbnailBitmap(),
                    width, height, objectThumbnailCornerRadius);
        }
        return objectThumbnail;
    }

}
