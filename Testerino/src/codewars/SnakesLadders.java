package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class SnakesLadders {
	public static boolean gameOver = false;
    public static int nextPlayerIndex = 0, gameTurn = 0;
    public static ArrayList<Player> players = new ArrayList<>(Arrays.asList(new Player("Player 1"), new Player("Player 2")));
    public static Map<Integer, Integer> squares = Map.ofEntries(
			Map.entry(2, 36), Map.entry(7, 7), Map.entry(8, 23), Map.entry(15, 11), Map.entry(16, -10), Map.entry(21, 21), Map.entry(28, 56),
			Map.entry(36, 8), Map.entry(46, -21), Map.entry(49, -38), Map.entry(51, 16), Map.entry(62, -43), Map.entry(64, -4), Map.entry(71, 20),
			Map.entry(74, -21), Map.entry(78, 20), Map.entry(87, 7), Map.entry(89, -21), Map.entry(92, -4), Map.entry(95, -20), Map.entry(99, -19)
			);
  
   public SnakesLadders() {}
   public String play(int die1, int die2) {
        if (gameTurn >= 50) {
          cleanUp();
        } else if (gameOver) {
          cleanUp();
          return "Game over!";
        }

      Player currentPlayer = players.get(nextPlayerIndex);
      move(currentPlayer, die1, die2);
      checkBounce(currentPlayer);
      checkLadderOrSnake(currentPlayer);
      if (checkWin(currentPlayer)) {
    	  gameOver = true;
    	  return currentPlayer.getName() + " Wins!";
      }
      changeTurn(die1, die2);
      return currentPlayer.toString();
    }
    private boolean checkWin(Player player) {
		if (player.getPos() == 100) return true;
		return false;
	}
	private void checkBounce(Player player) {
		if (player.getPos() > 100) {
			player.setPos(100 - (player.getPos()-100));
		}
	}
	
	private void changeTurn(int die1, int die2) {
		gameTurn++;
    if (die1 == die2) return;
		if (nextPlayerIndex == 1) {
			nextPlayerIndex--;
		} else {
			nextPlayerIndex++;
		}
	}
	
	private void cleanUp() {
    gameOver = false;
	players.forEach(a -> a.cleanUp());
	nextPlayerIndex = gameTurn = 0;
	}
	
	private void move(Player player, int die1, int die2) {
		player.setPos(player.getPos() + die1 + die2);
	}
	
	private void checkLadderOrSnake(Player player) {
		if (squares.containsKey(player.getPos())) {
			move(player, squares.get(player.getPos()), 0);
		}
	}
	
}

class Player {
	private int pos;
	private String name;
	public Player(String name) {
		this.pos = 0;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int newPos) {
		pos = newPos;
	}
	public void cleanUp() {
		pos = 0;
	}
	@Override
	public String toString() {
		return name + " is on square " + pos;
	}
}
