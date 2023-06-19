package tetris.engine.model;

import java.awt.Graphics;
import java.util.ArrayList;

import tetris.engine.observer.ScoreObserver;

public class Board {
	
	private final int width = 10, heigth = 20;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<ScoreObserver> scoreObservers = new ArrayList<>();
	public void update() {
		//TODO
	}
	public void addScoreObserver(ScoreObserver observer) {
	    scoreObservers.add(observer);
	}

	public void removeScoreObserver(ScoreObserver observer) {
	    scoreObservers.remove(observer);
	}

	public void paint(Graphics g) {
		for (Block block : blocks) {
			block.paint(g);
		}
	}
	
	public void setShapeToBoard(Shape shape) {
		for (Block block : shape.getBlocks()) {
			boolean flag = true;
			for (Block block2 : blocks) {
				if(block.getX() == block2.getX() && block.getY() == block2.getY()) {
					flag = false;
					block2.setColor(block.getColor());
				}
			}
			if(flag) {
				this.blocks.add(block);
			}
		}
	}
	
	public int checkLine() {
		//TODO
		int score = 0;
		int line[] = new int[20];
		for (int i = 0; i < line.length; i++) {
			line[i] = 0;
		}
		for (Block block : blocks) {
			if(block.getY() >= 0) {
				line[block.getY()]++;
			}
		}
		for (int i = 0; i < line.length; i++) {
			if (line[i] == 10) {
				score++;
				int j = i;
				blocks.removeIf(n -> n.getY() == j);
				for (Block block : blocks) {
					if(block.getY() < i) {
						block.setLocal(block.getX(), block.getY() + 1);
					}
				}
			}
			
		}	
		
	

		return score;
	}
//	int linesCleared = board.checkLine();
//	System.out.println("Lines cleared: " + linesCleared);

	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	
}
