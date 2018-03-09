package ru.rsreu.Zhilenko0804.dao;

import java.util.List;

import ru.rsreu.Zhilenko0804.data.Request;

public interface RequestDAO {
	public List<Request> getReportsFromConference(int idConference);

	public boolean createRequest(int idClient, String nameReport,
			int idConference);
}
