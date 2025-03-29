package com.ISCOD_Eval.pmt_backend.repositories;

import com.ISCOD_Eval.pmt_backend.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title); // ✅ Ensures only one result
}
