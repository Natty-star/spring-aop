package edu.miu.cs545.restApi.repo;

import edu.miu.cs545.restApi.domain.Post;
import edu.miu.cs545.restApi.domain.dto.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByTitle(String title);
}
