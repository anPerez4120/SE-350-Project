package fp;

import java.awt.Point;
import java.util.Random;

/**
 * Class that holds all the information of what is on the map. 
 * @author Anthony Perez 
 */
public class OceanMap {
	int[][] islands;
	int dimensions;
	int islandCount;
	final int ship = 1;
	final int speedBoost = 2;
	final int inverseCurse = 3;
	final int treasure = 4;
	final int monster = 5;
	final int pirate = 6;
	final int island = 7;
	Random rand = new Random();
	Point shipLocation ,monsterLocation, monsterLocation2;

	private static OceanMap instance;

	private OceanMap(int dimensions, int islandCount) {
		this.dimensions = dimensions;
		this.islandCount = islandCount;
		createGrid();
		placeIslands();
		placeSpeedBoost();
		placeInverseCurse();
		placeTreasure();
		shipLocation = placeShip(); // creates initial shipLocation through the method call
		monsterLocation = placeMonster();
		monsterLocation2 = placeMonster();
	}

	public static synchronized OceanMap getInstance(int dimensions, int islandCount) {
		if (instance == null) {
			instance = new OceanMap(dimensions, islandCount);
		}
		return instance;
	}
	
	// creates an empty map
	public void createGrid() { 
		islands = new int[dimensions][dimensions];
		for (int row = 0; row < dimensions; row++) {
			for (int col = 0; col < dimensions; col++) {
				islands[row][col] = 0;
			}
		}
	}

	// places islands on the map, making sure the location is not occupied
	private void placeIslands() {
		int islandsToPlace = islandCount;
		while (islandsToPlace > 0) {
			int x = rand.nextInt(dimensions);
			int y = rand.nextInt(dimensions);
			if (islands[x][y] == 0) {
				islands[x][y] = island;
				islandsToPlace--;
			}
		}
	}

	// finds an empty position on the map and places the ship there when the
	// constructor call this method
	public Point placeShip() {
		boolean placedShip = false;
		int x = 0, y = 0;
		while (!placedShip) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (islands[x][y] == 0) {
				placedShip = true;
				islands[x][y] = ship;
			}
		}
		return new Point(x, y);
	}
	
	//finds an empty location to place the speedboost. When one is found the index is set equal to speedBoost
	private void placeSpeedBoost() {
		boolean placedSpeedBoost = false;
		int x = 0, y = 0;
		while (!placedSpeedBoost) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (isOcean(x, y)) {
				islands[x][y] = speedBoost;
				placedSpeedBoost = true;
			}
		}
	}
	
	//finds a random empty location to place the inverseCurse. When one is found the index is set equal to inverseCurse
	private void placeInverseCurse() {
		boolean placedSpeedBoost = false;
		int x = 0, y = 0;
		while (!placedSpeedBoost) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (isOcean(x, y)) {
				islands[x][y] = inverseCurse;
				placedSpeedBoost = true;
			}
		}
	}

	//finds a random empty location to place the treasure. when one is found the index is set equal to treasure
	private void placeTreasure() {
		boolean placedSpeedBoost = false;
		int x = 0, y = 0;
		while (!placedSpeedBoost) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (isOcean(x, y)) {
				islands[x][y] = treasure;
				placedSpeedBoost = true;
			}
		}
	}

	//finds a random empty location on the grid to place the monster.  
	public Point placeMonster() {
		boolean placedMonster = false;
		int x = 0, y = 0;
		while (!placedMonster) {
			x = rand.nextInt(dimensions);
			y = rand.nextInt(dimensions);
			if (islands[x][y] == 0) {
				placedMonster = true;
				islands[x][y] = monster;
			}
		}
		return new Point(x, y);
	}

	//returns ship location
	public Point getShipLocation() {
		return shipLocation;
	}

	//returns monster location
	public Point getMonsterLocation() {
		return monsterLocation;
	}

	//returns monster location
	public Point getMonsterLocation2() {
		return monsterLocation2;
	}

	//returns map
	public int[][] getMap() {
		return islands;
	}

	//returns dimensions
	public int getDimensions() {
		return dimensions;
	}
	
	// checks to make sure the location is not occupied
	public boolean isOcean(int x, int y) { 
		if (islands[x][y] == 0) {
			return true;
		} else
			return false;
	}

	// checks to see if the location is mountable (i.e. ocean, ship, power-up, treasure, etc.)
	public boolean isMountable(int x, int y) {
		if (islands[x][y] <= 6)
			return true;
		else
			return false;
	}
}
