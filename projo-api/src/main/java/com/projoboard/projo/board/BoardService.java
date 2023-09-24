package com.projoboard.projo.board;

import com.projoboard.projo.task.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for Board
 */
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final TaskRepository taskRepository;

    public BoardService(BoardRepository boardRepository, TaskRepository taskRepository) {
        this.boardRepository = boardRepository;
        this.taskRepository = taskRepository;
    }

    /**
     * Find all Board entries
     *
     * @return list of all Board entries
     */
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    /**
     * Find a Board entry with a specified ID
     *
     * @param id id of Board to find
     * @return Board object if found, else null
     */
    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    /**
     * Create a new Board entry
     *
     * @param board Board object to save in the repository
     * @return created Board object, this object will have a new ID
     */
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    /**
     * Update Board entry in the repository, if the entry with the specified ID doesn't exist
     * a new entry will be created
     *
     * @param id    ID of a Board to update
     * @param board Board object with different fields
     * @return updated Board object
     */
    public Board updateBoard(Long id, Board board) {
        board.setId(id);
        return boardRepository.save(board);
    }

    /**
     * Delete Board entry with specified ID
     *
     * @param id ID of Board to delete
     */
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
