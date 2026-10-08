package com.college.erp.service;

import com.college.erp.dao.ResultDAO;
import com.college.erp.model.Result;

import java.util.List;

public class ResultService {

    private final ResultDAO resultDAO;

    public ResultService() {
        this.resultDAO = new ResultDAO();
    }

    public boolean addResult(Result result) {
        return resultDAO.addResult(result);
    }

    public List<Result> getAllResults() {
        return resultDAO.getAllResults();
    }

    public Result getResultById(int id) {
        return resultDAO.getResultById(id);
    }

    public boolean updateResult(Result result) {
        return resultDAO.updateResult(result);
    }

    public boolean deleteResult(int id) {
        return resultDAO.deleteResult(id);
    }
}