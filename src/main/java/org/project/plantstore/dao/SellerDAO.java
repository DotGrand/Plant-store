package org.project.plantstore.dao;

import org.project.plantstore.entity.Seller;

import java.util.List;

public interface SellerDAO {

    List<Seller> getSellers();

    void saveSeller(Seller seller);

    Seller getSeller(Long id);

    void deleteSeller(Long id);

    List<Seller> searchSeller(String searchSeller);
}
