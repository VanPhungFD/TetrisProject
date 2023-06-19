package tetris.engine.observer;

public class ScoreCounter implements ScoreObserver {
	

		private int currentScore;

		public int getCurrentScore() {
			return currentScore;
		}

		@Override
		public void onScoreChanged(int score) {
			currentScore = score;
			System.out.println("Current scoreObserver: " + currentScore);
		}
	}

