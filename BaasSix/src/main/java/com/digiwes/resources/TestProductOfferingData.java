package com.digiwes.resources;

import com.digiwes.basetype.TimePeriod;
import com.digiwes.common.enums.ProductOfferingStatus;

/**
 * Created by liurl3 on 2015/7/10.
 */
public class TestProductOfferingData {
    // 商品 （id，name，description，validFor，status）
    public static Object[][] offering = {
            {"1", "2.7GHz处理器128GB存储容量", "【2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz 基于 PCIe 的 128GB 闪存】", new TimePeriod
                    ("2015-08-03 12:00:00", "2019-09-21 23:59:59"), ProductOfferingStatus.ACTIVE.getValue()},
            {"2", "2.7GHz处理器256GB存储容量", "【2.7GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.1GHz 基于 PCIe 的 256GB 闪存】", new TimePeriod
                    ("2015-08-03 12:00:00", "2019-09-21 23:59:59"), ProductOfferingStatus.ACTIVE.getValue()},
            {"3", "2.9GHz处理器512GB存储容量", "【2.9GHz 双核 Intel Core i5 处理器 Turbo Boost 高达 3.3GHz 基于 PCIe 的 512GB 闪存】", new TimePeriod
                    ("2015-08-03 12:00:00",
                    "2019-09-21 23:59:59"), ProductOfferingStatus.ACTIVE.getValue()},
            {"4", "VirtualStorageMedium", "Virtual Storage Medium", new TimePeriod
                    ("2015-08-03 12:00:00",
                            "2019-09-21 23:59:59"), ProductOfferingStatus.ACTIVE.getValue()}
    };
}
