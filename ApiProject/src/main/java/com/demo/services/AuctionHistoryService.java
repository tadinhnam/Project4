package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.Dtos.Input.AuctionHistoryInput;
import com.demo.Dtos.Output.AuctionHistoryOutput;
import com.demo.Dtos.Output.AuctionOutput;
import com.demo.models.Account;
import com.demo.models.Auction;
import com.demo.models.Auctionhistory;
import com.demo.models.Product;
import com.demo.reponsitories.AuctionHistoryResponsitory;

@Service
public class AuctionHistoryService implements IAuctionHistoryService {
	@Autowired
	private AuctionHistoryResponsitory auctionHistoryResponsitory;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IProductService productService;

	@Autowired
	private IAuctionService auctionService;

	@Override
	public List<AuctionHistoryOutput> getlistAuctionHistory() {
		return auctionHistoryResponsitory.getlistAuctionHistory();
	}

	@Override
	public boolean createAuctionHistory(AuctionHistoryInput auctionHistoryInput) {
		Auctionhistory auctionhistory = new Auctionhistory();
		Account account = accountService.findById(auctionHistoryInput.getAccountid());
		Auction auction = auctionService.findById(auctionHistoryInput.getAuctionid());
		Product product = productService.findById(auctionHistoryInput.getProductid());
		if (account == null || auction == null || product == null) {
			return false;
		}
		auctionhistory.setAccount(account);
		auctionhistory.setAuction(auction);
		auctionhistory.setProduct(product);
		auctionhistory.setPrice(auctionHistoryInput.getPrice());
		auctionhistory.setTime(new Date());
		return auctionHistoryResponsitory.save(auctionhistory) != null;
	}

	@Override
	public List<AuctionHistoryOutput> getAuctionHistoryByCustomer(int accountid) {
		return auctionHistoryResponsitory.getAuctionHistoryByCustomer(accountid);
	}

	@Override
	public List<AuctionHistoryOutput> getAuctionHistoryById(int auctionId) {
		List<Auctionhistory> auctionhistories = auctionHistoryResponsitory.getAuctionHistoryById(auctionId);
		List<AuctionHistoryOutput> auctionHistoryOutputs = new ArrayList<AuctionHistoryOutput>();
		for (Auctionhistory auction : auctionhistories) {
			AuctionHistoryOutput auctionHistoryOutput = new AuctionHistoryOutput();
			auctionHistoryOutput.setAccountname(auction.getAccount().getFullname());
			auctionHistoryOutput.setEventdate(auction.getAuction().getEventdate());
			auctionHistoryOutput.setHourEnd(auction.getAuction().getHourEnd());
			auctionHistoryOutput.setHourStart(auction.getAuction().getHourStart());
			auctionHistoryOutput.setPrice(auction.getPrice());
			auctionHistoryOutput.setProductname(auction.getProduct().getName());
			auctionHistoryOutput.setTime(auction.getTime());
			auctionHistoryOutput.getProductOutput().setId(auction.getProduct().getId());
			auctionHistoryOutput.getProductOutput().setCategory(auction.getProduct().getCategory().getName());
			auctionHistoryOutput.getProductOutput().setPriceMin(auction.getProduct().getPriceMin());
			auctionHistoryOutput.getProductOutput().setImage(auction.getProduct().getImage());
			auctionHistoryOutput.getProductOutput().setDescription(auction.getProduct().getDescription());
			auctionHistoryOutput.getProductOutput().setStatus(auction.getProduct().getStatus());
			auctionHistoryOutput.getProductOutput().setName(auction.getProduct().getName());
			auctionHistoryOutputs.add(auctionHistoryOutput);
		}
		return auctionHistoryOutputs;
	}

	@Override
	public int countAuctionHistoryById(int id) {
		return auctionHistoryResponsitory.countAuctionHistoryById(id);
	}

	@Override
	public double maxPriceAuctionHistoryById(int id) {
		return auctionHistoryResponsitory.maxPriceAuctionHistoryById(id);
	}

	@Override
	public List<AuctionOutput> getAuctionByIdCustomer(int idCus) {
		List<AuctionOutput> auctionOutputs = auctionHistoryResponsitory.getAuctionByIdCustomer(idCus);
		for (AuctionOutput auctionOutput : auctionOutputs) {
			List<AuctionHistoryOutput> auctionHistoryOutput = auctionHistoryResponsitory.getAuction(idCus, auctionOutput.getId());
			auctionOutput.setAuctionHistoryOutputs(auctionHistoryOutput);
		}
		return auctionOutputs;
	}

}
