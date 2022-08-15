package org.project.plantstore.service;

import org.project.plantstore.entity.Seller;

import java.util.List;

public interface SellerService {

    List<Seller> getSellers();

    void saveSeller(Seller seller);

    Seller getSeller(Long id);

    void deleteSeller(Long id);

    List<Seller> searchSeller(String searchSeller);
}
