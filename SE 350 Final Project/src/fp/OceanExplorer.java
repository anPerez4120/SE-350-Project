package fp;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * Launches the GUI. 
 * @author Anthony Perez 
 */
public class OceanExplorer extends Application {

	ArrayList<Pirate> pirates = new ArrayList<>();
	ArrayList<ImageView> pirateImageViews = new ArrayList<>();
	int[][] islandMap;
	AnchorPane root;
	final int dimensions = 20;
	final int islandCount = 50;
	final int scale = 33;
	OceanMap oceanMap;
	Image shipImage, islandImage, pirateImage, powerImage, monsterImage, treasureImage;
	ImageView shipImageView, islandImageView, powerImageView, treasureImageView, monsterImageView1, monsterImageView2;
	Scene scene;
	Ship ship;
	Monster monster1;
	Monster2 monster2;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = OceanMap.getInstance(dimensions, islandCount);
		islandMap = oceanMap.getMap();

		root = new AnchorPane();
		drawMap();

		ship = new ChristopherColumbus(oceanMap);

		Pirate pirate1 = new Pirate(oceanMap);
		ImageView pirateImageView = new ImageView();
		Pirate pirate2 = new Pirate(oceanMap);
		ImageView pirateImageView2 = new ImageView();
		pirates.add(pirate1);
		pirates.add(pirate2);
		pirateImageViews.add(pirateImageView);
		pirateImageViews.add(pirateImageView2);
		ship.addObserver(pirate1);
		ship.addObserver(pirate2);

		monster1 = new Monster(oceanMap);
		monster2 = new Monster2(oceanMap);

		loadIslandImage();
		loadShipImage();
		loadPirateImage();
		loadMonsterImage();

		scene = new Scene(root, 675, 675);
		oceanStage.setTitle("My Island");
		oceanStage.setScene(scene);
		oceanStage.show();

		Context context = new Context();
		StartState startState = new StartState();
		startState.checkShip(context);

		startSailing();
	}

	public void drawMap() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (islandMap[x][y] == oceanMap.island) {
					rect.setFill(Color.GREEN);
				} else
					rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect);
			}
		}
	}

	public void loadIslandImage() {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				//finds where islands are and places island images there
				if (islandMap[x][y] == oceanMap.island) { 
					Image islandImage = new Image("island.jpg", scale, scale, true, true);
					islandImageView = new ImageView(islandImage);
					islandImageView.setX(x * scale);
					islandImageView.setY(y * scale);
					root.getChildren().add(islandImageView);
				}
				//finds where power-ups are and power-up images there
				else if (islandMap[x][y] == oceanMap.speedBoost || islandMap[x][y] == oceanMap.inverseCurse) {
					Image powerImage = new Image("qblock.png", scale, scale, true, true);
					powerImageView = new ImageView(powerImage);
					powerImageView.setX(x * scale);
					powerImageView.setY(y * scale);
					root.getChildren().add(powerImageView);
				}
				
				//finds where treasure is and places treasure image there
				else if (islandMap[x][y] == oceanMap.treasure) {
					Image treasureImage = new Image("treasurechest.png", scale, scale, true, true);
					treasureImageView = new ImageView(treasureImage);
					treasureImageView.setX(x * scale);
					treasureImageView.setY(y * scale);
					root.getChildren().add(treasureImageView);
				}
			}
		}
	}
	
	//iterates through the pirates to get there locations and places pirateImageView there
	public void loadPirateImage() {
		pirateImage = new Image("pirateShip.png", scale, scale, true, true);
		for (int i = 0; i < pirates.size(); i++) {
			pirateImageViews.get(i).setImage(pirateImage);
			pirateImageViews.get(i).setX(pirates.get(i).getPiratePosition().x * scale);
			pirateImageViews.get(i).setY(pirates.get(i).getPiratePosition().y * scale);
			root.getChildren().add(pirateImageViews.get(i));
		}
	}

	// obtains shipLocation and places shipImageView there
	public void loadShipImage() {
		Image shipImage = new Image("ship.png", scale, scale, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * scale);
		shipImageView.setY(ship.getShipLocation().y * scale);
		root.getChildren().add(shipImageView);
	}

	//obtains monster locations and puts monster images there
	private void loadMonsterImage() {
		Image monsterImage = new Image("monster.jpg", scale, scale, true, true);
		monsterImageView1 = new ImageView(monsterImage);
		monsterImageView2 = new ImageView(monsterImage);
		monsterImageView1.setX(monster1.getMonsterPosition().x * scale);
		monsterImageView1.setY(monster1.getMonsterPosition().y * scale);
		monsterImageView2.setX(monster2.getMonsterPosition2().x * scale);
		monsterImageView2.setY(monster2.getMonsterPosition2().y * scale);
		root.getChildren().add(monsterImageView1);
		root.getChildren().add(monsterImageView2);
	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				// making sure to update the image location whenever the ship moves
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);

				monster1.move();
				monsterImageView1.setY(monster1.getMonsterPosition().y * scale);
				monster2.move();
				monsterImageView2.setX(monster2.getMonsterPosition2().x * scale);

				Context context = new Context();
				MoveState moveState = new MoveState();
				StopState stopState = new StopState();
				WinState winState = new WinState();
				PowerState powerState = new PowerState();
				CurseState curseState = new CurseState();

				moveState.checkShip(context);

				//if the ship found the treasure then end the game, and announce that the player has won
				if (islandMap[ship.getShipLocation().x][ship.getShipLocation().y] == oceanMap.treasure) {
					winState.checkShip(context);
				}

				// assigns a power-up to the ship depending if they found one
				else if (islandMap[ship.getShipLocation().x][ship.getShipLocation().y] == oceanMap.speedBoost) {
					ship = new SpeedBoost(ship);
					powerState.checkShip(context);
				} else if (islandMap[ship.getShipLocation().x][ship.getShipLocation().y] == oceanMap.inverseCurse) {
					ship = new InverseCurse(ship);
					curseState.checkShip(context);
				}
				
				//checks to see if any monster caught the ship, if so then GameOver
				else if (ship.getShipLocation().equals(monster1.getMonsterPosition())
						|| ship.getShipLocation().equals(monster2.getMonsterPosition2())) {
					stopState.checkShip(context);
				}
				
				//iterating through pirates and updating their imageViews 
				for (int i = 0; i < pirates.size(); i++) {
					pirateImageViews.get(i).setX(pirates.get(i).getPiratePosition().x * scale);
					pirateImageViews.get(i).setY(pirates.get(i).getPiratePosition().y * scale);
					ship.addObserver(pirates.get(i));
					
					//checks to see if any pirate caught the ship, if so then GameOver
					if (ship.getShipLocation().equals(pirates.get(i).getPiratePosition())) {
						stopState.checkShip(context);
					}
				}
			}
		});
	}
}