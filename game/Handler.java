package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import objects.Block;

public class Handler {
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	private GameObject tempObject;

	// Update graphics
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);
			tempObject.tick(object);
		}
	}

	// Renders the object
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			tempObject = object.get(i);

			Color color = null;
			if (tempObject.getId() == ObjectId.PLAYER)
				color = new Color(220, 45, 45); // Red
			if (tempObject.getId() == ObjectId.WALL)
				color = new Color(150, 220, 104); // Green
			if (tempObject.getId() == ObjectId.EXIT)
				color = new Color(239, 88, 253); // Purple
			if (tempObject.getId() == ObjectId.PATH)
				color = new Color(220, 177, 45); // Brown
			if (tempObject.getId() == ObjectId.GEM)
				color = new Color(19, 230, 255); // Cyan
			if (tempObject.getId() == ObjectId.VOID)
				color = Color.BLACK; // Black

			tempObject.render(g, color);
		}
	}

	// Adds an object to the ObjectList
	public void addObject(GameObject object) {
		this.object.add(object);
	}

	// Removes an object from the ObjectList
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}


	public void createLevel() {
		for (int yy = 0; yy < Game.HEIGHT; yy += 32) {
			for (int xx = 0; xx < Game.WIDTH - 32; xx += 32) {
				if (yy == 1 << 5) {
					if (xx == 4 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 12 << 5)
						this.addObject(new Block(xx, yy, ObjectId.EXIT));
					else if (xx == 16 << 5)
						this.addObject(new Block(xx, yy, ObjectId.GEM));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 2 << 5) {
					if (xx == 4 << 5 || xx == 12 << 5 || xx == 16 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 3 << 5) {
					if (xx == 32 || xx == 2 << 5 || xx == 3 << 5 || xx == 4 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 6 << 5 || xx == 7 << 5 || xx == 8 << 5 || xx == 9 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 12 << 5 || xx == 16 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 4 << 5) {
					if (xx == 4 << 5 || xx == 6 << 5 || xx == 9 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 12 << 5 || xx == 13 << 5 || xx == 14 << 5 || xx == 15 << 5 || xx == 16 << 5
							|| xx == 17 << 5 || xx == 18 << 5 || xx == 19 << 5 || xx == 20 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 5 << 5) {
					if (xx == 1 << 5)
						this.addObject(new Block(xx, yy, ObjectId.GEM));
					else if (xx == 2 << 5 || xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 6 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 9 << 5 || xx == 12 << 5 || xx == 15 << 5 || xx == 18 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 6 << 5) {
					if (xx == 6 << 5 || xx == 9 << 5 || xx == 10 << 5 || xx == 11 << 5 || xx == 12 << 5 || xx == 13 << 5
							|| xx == 14 << 5 || xx == 15 << 5 || xx == 18 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 7 << 5) {
					if (xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 6 << 5 || xx == 9 << 5 || xx == 12 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 15 << 5 || xx == 16 << 5 || xx == 17 << 5 || xx == 18 << 5 || xx == 19 << 5
							|| xx == 20 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 8 << 5) {
					if (xx == 3 << 5 || xx == 9 << 5 || xx == 12 << 5 || xx == 15 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 9 << 5) {
					if (xx == 3 << 5 || xx == 8 << 5 || xx == 9 << 5 || xx == 10 << 5 || xx == 11 << 5 || xx == 13 << 5
							|| xx == 14 << 5 || xx == 15 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 12 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PLAYER));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 10 << 5) {
					if (xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 6 << 5 || xx == 7 << 5 || xx == 8 << 5
							|| xx == 12 << 5 || xx == 15 << 5 || xx == 21 << 5 || xx == 22 << 5 || xx == 23 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 11 << 5) {
					if (xx == 3 << 5 || xx == 12 << 5 || xx == 15 << 5 || xx == 16 << 5 || xx == 17 << 5
							|| xx == 18 << 5 || xx == 19 << 5 || xx == 20 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 7 << 5)
						this.addObject(new Block(xx, yy, ObjectId.GEM));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 12 << 5) {
					if (xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 7 << 5 || xx == 9 << 5 || xx == 10 << 5
							|| xx == 11 << 5 || xx == 12 << 5 || xx == 15 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 13 << 5) {
					if (xx == 5 << 5 || xx == 6 << 5 || xx == 7 << 5 || xx == 8 << 5 || xx == 9 << 5 || xx == 14 << 5
							|| xx == 15 << 5 || xx == 16 << 5 || xx == 17 << 5 || xx == 18 << 5 || xx == 19 << 5
							|| xx == 20 << 5 || xx == 21 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 14 << 5) {
					if (xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 9 << 5 || xx == 14 << 5 || xx == 17 << 5
							|| xx == 20 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 15 << 5) {
					if (xx == 3 << 5 || xx == 5 << 5 || xx == 9 << 5 || xx == 10 << 5 || xx == 11 << 5 || xx == 12 << 5
							|| xx == 13 << 5 || xx == 14 << 5 || xx == 20 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 17 << 5)
						this.addObject(new Block(xx, yy, ObjectId.GEM));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 16 << 5) {
					if (xx == 1 << 5 || xx == 2 << 5 || xx == 3 << 5 || xx == 4 << 5 || xx == 5 << 5 || xx == 9 << 5
							|| xx == 11 << 5 || xx == 14 << 5 || xx == 15 << 5 || xx == 16 << 5 || xx == 17 << 5
							|| xx == 18 << 5 || xx == 19 << 5 || xx == 20 << 5 || xx == 21 << 5 || xx == 22 << 5
							|| xx == 23 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 17 << 5) {
					if (xx == 5 << 5 || xx == 9 << 5 || xx == 11 << 5 || xx == 14 << 5 || xx == 20 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				} else if (yy == 18 << 5) {
					if (xx == 5 << 5 || xx == 9 << 5 || xx == 14 << 5 || xx == 20 << 5)
						this.addObject(new Block(xx, yy, ObjectId.PATH));
					else if (xx == 11 << 5)
						this.addObject(new Block(xx, yy, ObjectId.GEM));
					else if (xx == 0 || xx == 24 << 5)
						this.addObject(new Block(xx, yy, ObjectId.VOID));
					else
						this.addObject(new Block(xx, yy, ObjectId.WALL));
				}
			}
		}
	}
}
