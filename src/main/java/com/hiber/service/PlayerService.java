package com.hiber.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hiber.model.Player;

public interface PlayerService {

	public List<Player> selectPlayers() throws Exception;

	//public void insertPlayer(Map<String, Object> params) throws Exception;
	public void insertPlayer(Player player) throws Exception;

	public List<Player> searchPlayers(String keyword) throws Exception;

	public void updatePlayer() throws Exception;

}
