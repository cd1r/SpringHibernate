package com.hiber.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hiber.dao.PlayerDAO;
import com.hiber.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Inject
	PlayerDAO playerDAO;
	
	@Override
	public List<Player> selectPlayers() throws Exception {
		//return playerDAO.selectPlayers_SPMap();
		return playerDAO.selectPlayers_Hib();
	}

	@Override
	public void insertPlayer(Player player) throws Exception {
		playerDAO.insertPlayer_Hib(player);
	}
	/*public void insertPlayer(Map<String, Object> params) throws Exception {
		playerDAO.insertPlayer_Hib(params);
	}*/

	@Override
	public List<Player> searchPlayers(String keyword) throws Exception {
		return playerDAO.searchPlayers(keyword);
	}

	@Override
	public void updatePlayer() throws Exception {
		playerDAO.updatePlayer();
	}

}
