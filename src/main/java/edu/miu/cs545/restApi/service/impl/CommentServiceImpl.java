package edu.miu.cs545.restApi.service.impl;

import edu.miu.cs545.restApi.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {
    @Autowired
    private CommentRepository commentRepository;
}
