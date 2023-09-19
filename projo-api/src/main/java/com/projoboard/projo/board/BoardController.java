package com.projoboard.projo.board;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for boards endpoint
 */
@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * Method to parse a GET request
     * Returns all boards
     *
     * @return list of boards
     */
    @GetMapping("")
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    /**
     * Method to parse a GET request
     * Get a board with ID specified in URI
     *
     * @param id ID of a board to get
     * @return board with the specified ID
     */
    @GetMapping("/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    /**
     * Method to parse a POST request
     * Create a new board
     *
     * @param board Board object passed through Request Body
     * @return the created board object with a new ID
     */
    @PostMapping("")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    /**
     * Method to parse a PUT request
     * Update a board with an ID specified in URI, if the entry with specified ID doesn't exist,
     * a new object with this ID will be created
     *
     * @param id    ID of a board to update
     * @param board board object with fields to update
     * @return the updated board object
     */
    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Long id, @RequestBody Board board) {
        return boardService.updateBoard(id, board);
    }

    /**
     * Method to parse a DELETE request
     * Delete a board with an ID specified in URI
     *
     * @param id ID of a board to delete
     */
    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
    }
}
