package tetris.engine.observer;

	public class LevelObserver implements Observer {
	    @Override
	    public void update() {
	        // Thực hiện cập nhật logic khi có sự thay đổi về currentShape
	        // Ví dụ: Cập nhật cấp độ dựa trên currentShape
	        System.out.println("Level has been updated!");
	    }
}
