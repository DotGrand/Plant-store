package org.project.plantstore.service;

import org.project.plantstore.dao.SellerDAO;
import org.project.plantstore.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDAO sellerDAO;

    @Override
    public List<Seller> getSellers() {
        return sellerDAO.getSellers();
    }

    @Override
    public void saveSeller(Seller seller) {
        sellerDAO.saveSeller(seller);
    }

    @Override
    public Seller getSeller(Long id) {
        return sellerDAO.getSeller(id);
    }

    @Override
    public void deleteSeller(Long id) {
        sellerDAO.deleteSeller(id);
    }

    @Override
    public List<Seller> searchSeller(String searchSeller) {
        return sellerDAO.searchSeller(searchSeller);
    }
}
