package edu.miu.cs545.restApi.service;

import edu.miu.cs545.restApi.domain.Comment;
import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.dto.PostDto;
import edu.miu.cs545.restApi.domain.dto.PostDtoV2;

import java.util.List;

public interface PostService {
    List<PostDto> getAll();
    PostDto getById(Long id);
    void save(PostDto postDto);
    void delete(Long id);
    void update(Long id, PostDto postDto);

    List<PostDtoV2> getAll2();

    void addComment(Long id, List<Comment> comment);

    List<Comment> getPostComments(Long id);

    List<Post> getPostsLikeTitle(String title);
}
