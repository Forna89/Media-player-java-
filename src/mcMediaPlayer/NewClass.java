/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import mcMediaPlayer.FileSelected;

/**
 *
 * @author RE COMPUTER
 */
public class McMediaPlayer extends Application{
    Stage stage= null;
    BorderPane bdp=new BorderPane();
    BorderPane bdp2=new BorderPane();
    TableView tbView = new TableView();
    StackPane stp= new StackPane();
    FileSelected fs;
    Scene sc1;
    Scene sc2;
    Media media = null;
    MediaPlayer mediaPlayer = null;
    MediaView mediaView = null;
    ToolBar tBar= new ToolBar();
    FileChooser fileChooser = null;
    Button btStop = new Button();
    Button btMute = new Button();
    Button btPlay = new Button();
    Button btNext= new Button();
    Button btPreview= new Button();
    Button btNext15= new Button();
    Button btPreview15= new Button();
    Button btIncreaseV= new Button();
    Button btDecreaseV= new Button();
    Button fullS = new Button();
    List <File> fileList= new ArrayList<>();
    Slider slider = new Slider();
    MenuBar mnBar= new MenuBar();
    ObservableList<FileSelected> fsList;
    ObservableList<Media> mediaList;
    
    ImageView imgPause=new ImageView("/img/icons/pause.png");
    ImageView imgPlay=new ImageView("/img/icons/play.png");
    ImageView imgStop=new ImageView("/img/icons/stop.png");
    ImageView imgNext=new ImageView("/img/icons/next.png");
    ImageView imgPreview=new ImageView("/img/icons/preview.png");
    ImageView imgMute=new ImageView("/img/icons/mute.png");
    ImageView imgUnmute=new ImageView("/img/icons/volume.png");
    ImageView imgFullS=new ImageView("/img/icons/fullS.png");
    ImageView imgVolUp=new ImageView("/img/icons/volumeUp.png");
    ImageView imgVolD=new ImageView("/img/icons/VolumeD.png");
    ImageView mniimgPlay=new ImageView("/img/icons/play.png");
    ImageView mniimgStop=new ImageView("/img/icons/stop.png");
    ImageView mniimgNext=new ImageView("/img/icons/next.png");
    ImageView mniimgPreview=new ImageView("/img/icons/preview.png");
    ImageView mniimgMute=new ImageView("/img/icons/mute.png");
    ImageView mniimgUnmute=new ImageView("/img/icons/volume.png");
    ImageView mniimgFullS=new ImageView("/img/icons/fullS.png");
    ImageView mniimgVolUp=new ImageView("/img/icons/volumeUp.png");
    ImageView mniimgVolD=new ImageView("/img/icons/VolumeD.png");
    ImageView imgNext30=new ImageView("/img/icons/next30.png");
    ImageView imgQuit=new ImageView("/img/icons/quit.png");
    ImageView mniimgOpenF=new ImageView("/img/icons/addfile.png");
    ImageView mniimgOpenMF=new ImageView("/img/icons/addfile.png");
    ImageView mniimgCreateP=new ImageView("/img/icons/playlist.png");
    ImageView mniimgCreateP2=new ImageView("/img/icons/playlist.png");

    ImageView mniimgZoom=new ImageView("/img/icons/zoom.png");
    int currentMediaIndex;
    int comptt=0;
    int sizeFileList;
    
    
    public static void main(String[] args) {
    
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        stage= pStage;
        window();
    }

    void window() {
        stage.setTitle("MC Media Player");
        stage.setMinWidth(200);
        stage.setHeight(460);
        stage.setWidth(650);
        stage.setMinHeight(200);
        stage.getIcons().add(new ImageView("/img/logo_MC_Play.png").getImage());
        mediaList = FXCollections.observableArrayList();
        fsList=FXCollections.observableArrayList();
        currentMediaIndex = 0;
        sc1 = new Scene(bdp);
        sc2 = new Scene(bdp2);
        fs=new FileSelected();
        stage.setScene(sc1); 
        
        imgPause.setFitWidth(15);
        imgPause.setFitHeight(15);
        imgPlay.setFitWidth(15);
        imgPlay.setFitHeight(15);
        imgStop.setFitHeight(15);
        imgNext.setFitHeight(15);
        imgPreview.setFitHeight(15);
        mniimgPlay.setFitWidth(10);
        mniimgPlay.setFitHeight(10);
        mniimgStop.setFitHeight(10);
        mniimgNext.setFitHeight(10);
        mniimgPreview.setFitHeight(10);
        mniimgStop.setFitWidth(10);
        mniimgNext.setFitWidth(10);
        mniimgPreview.setFitWidth(10);
        mniimgVolUp.setFitWidth(15);
        mniimgVolD.setFitWidth(15);
        mniimgVolUp.setFitHeight(10);
        mniimgVolD.setFitHeight(10);
        mniimgMute.setFitHeight(10);
        mniimgUnmute.setFitHeight(10);
        mniimgMute.setFitWidth(10);
        mniimgUnmute.setFitWidth(10);
        mniimgFullS.setFitHeight(10);
        mniimgFullS.setFitWidth(10);
        mniimgOpenF.setFitHeight(15);
        mniimgOpenF.setFitWidth(15);
        mniimgOpenMF.setFitHeight(15);
        mniimgOpenMF.setFitWidth(15);
        mniimgCreateP.setFitHeight(15);
        mniimgCreateP.setFitWidth(15);
        mniimgCreateP2.setFitHeight(15);
        mniimgCreateP2.setFitWidth(15);
        mniimgZoom.setFitHeight(15);
        mniimgZoom.setFitWidth(15);
        
        imgMute.setFitHeight(15);
        imgUnmute.setFitHeight(15);
        imgStop.setFitWidth(15);
        imgNext.setFitWidth(15);
        imgPreview.setFitWidth(15);
        imgMute.setFitWidth(15);
        imgUnmute.setFitWidth(15);
        
        imgVolUp.setFitWidth(18);
        imgVolD.setFitWidth(18);
        imgFullS.setFitHeight(15);
        imgFullS.setFitWidth(15);
        imgVolUp.setFitHeight(15);
        imgVolD.setFitHeight(15);
        imgNext30.setFitHeight(15);
        imgNext30.setFitWidth(15);
        imgQuit.setFitHeight(15);
        imgQuit.setFitWidth(15);
        
        btPlay.setGraphic(imgPlay);
        btStop.setGraphic(imgStop);
        btNext.setGraphic(imgNext);
        btNext15.setGraphic(imgNext30);
        btPreview.setGraphic(imgPreview);
        btMute.setGraphic(imgMute);
        fullS.setGraphic(imgFullS);
        btDecreaseV.setGraphic(imgVolD);
        btIncreaseV.setGraphic(imgVolUp);

        bdp.setStyle("-fx-background:#000");
        menuBar();
        
        bouton();
        playList();
             
        stage.show();
    }
    
    public void menuBar(){
        
        
        
        Menu mnMedia = new Menu("Media");
        Menu mnPlayback = new Menu("Playback");
        Menu mnAudio = new Menu("Audio");
        Menu mnVideo = new Menu("Video");
        Menu mnView = new Menu("View");
        
        
        MenuItem mniOpenF= new MenuItem("Open file");
        mniOpenF.setGraphic(mniimgOpenF);
        mniOpenF.setOnAction(e->{btPlay.fire();});
        MenuItem mniOpenMultiF= new MenuItem("Open Multipes files");
        mniOpenMultiF.setGraphic(mniimgOpenMF);
        mniOpenMultiF.setOnAction(e->{chooseFiles();});
        MenuItem mniQuit= new MenuItem("Quit");
        mniQuit.setGraphic(imgQuit);
        mniQuit.setOnAction(e->{stage.close();});
        MenuItem mniCreatePl= new MenuItem("Create palylist");
        mniCreatePl.setGraphic(mniimgCreateP);
        mniCreatePl.setOnAction((ActionEvent t) -> {
            stage.setScene(sc2);
        });
        
        MenuItem mniTitle= new MenuItem("Title");
        mniTitle.setOnAction(e->{});
        MenuItem mniPlay= new MenuItem("Play");
        mniPlay.setGraphic(mniimgPlay);
        mniPlay.setOnAction(e->{btPlay.fire();});
        MenuItem mniStop= new MenuItem("Stop");
        mniStop.setGraphic(mniimgStop);
        mniStop.setOnAction(e->{btStop.fire();});
        MenuItem mniPreview= new MenuItem("Preview");
        mniPreview.setGraphic(mniimgPreview);
        mniPreview.setOnAction(e->{btPreview.fire();});
        MenuItem mniNext= new MenuItem("Next");
        mniNext.setOnAction(e->{btNext.fire();});
        mniNext.setGraphic(mniimgNext);
        MenuItem mniIncreaseV= new MenuItem("Increase volume");
        mniIncreaseV.setGraphic(mniimgVolUp);
        mniIncreaseV.setOnAction(e->{});
        MenuItem mniDecreaseV= new MenuItem("Decrease volume");
        mniDecreaseV.setGraphic(mniimgVolD);
        mniDecreaseV.setOnAction(e->{});
        MenuItem mniMute= new MenuItem("Mute");
        mniMute.setGraphic(mniimgMute);
        mniMute.setOnAction(e->{btMute.fire();});
        MenuItem mniFullS= new MenuItem("Full screen");
        mniFullS.setGraphic(mniimgFullS);
        mniFullS.setOnAction(e->{ fullS.fire();});
        MenuItem mniZoom= new MenuItem("Zoom");
        mniZoom.setGraphic(mniimgZoom);
        mniZoom.setOnAction(e->{});
        
        MenuItem mniPL= new MenuItem("Playlist");
        mniPL.setGraphic(mniimgCreateP2);
        mniPL.setOnAction(e->{});
        
        mnMedia.getItems().addAll(mniOpenF, mniOpenMultiF,mniCreatePl ,mniQuit );
        mnPlayback.getItems().addAll(mniTitle, mniPlay, mniStop, mniPreview,mniNext);
        mnAudio.getItems().addAll(mniIncreaseV, mniDecreaseV,mniMute);
        mnVideo.getItems().addAll(mniFullS,mniZoom);
        mnView.getItems().add(mniPL);
        
       mnBar.getMenus().addAll(mnMedia,mnPlayback,mnAudio,mnVideo,mnView);
       bdp.setTop(mnBar);
       
    }
    public void toolBar(){
    tBar.getItems().addAll(btPlay, btStop,btPreview,btNext
            ,btNext15,btIncreaseV,btDecreaseV, btMute,fullS);
    bdp.setBottom(tBar);
    
    
    
    }
    void bouton() {
       // HBox hb = new HBox(10, btAddMedia,btPause, btStop, btMute);
       // hb.setPadding(new Insets(12));
        //bdp.setBottom(hb);
        toolBar();
        btPlay.setOnAction(e -> {
            if(fileChooser!=null){
                pauseMedia();
            }else{
                chooseFile();
                if(fileChooser!=null){btPlay.setGraphic(imgPause);}
            }   
        });
        btStop.setOnAction(e -> {
           stopMedia();
        });
        btMute.setOnAction(e -> {
            muteMedia();
        });
        btNext.setOnAction(e->{
            playNextMedia();
        });
        btPreview.setOnAction(e->{
            playPreviewMedia();
        });
        btNext15.setOnAction(e->{
            advance15();
        });
        btPreview15.setOnAction(e->{
            return15();
        });
        btIncreaseV.setOnAction(e->{
            increaveV();
        });
        btDecreaseV.setOnAction(e->{
            decreaseV();
        });
        fullS.setOnAction(e->{
            stage.setFullScreen(true);
           
            stage.fullScreenProperty().addListener(new ChangeListener<Boolean>(){
                @Override
                public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                    mnBar.setVisible(!t1);
                    tBar.setVisible(!t1);
                    mediaView.fitWidthProperty().bind(stage.widthProperty());
                    
                    
                }
                   
            });
            
            
            
            
        });
        
//       
    }

    void chooseFile() {
       
       fileChooser=new FileChooser();
       // 
       fileChooser.setTitle("Select a file");
       // fixer les extensions
       
       fileChooser.getExtensionFilters().addAll(
               new FileChooser.ExtensionFilter("mp4","*.mp4"),
               new FileChooser.ExtensionFilter("mp3","*.mp3")
               ,new FileChooser.ExtensionFilter("flv","*.flv")
               ,new FileChooser.ExtensionFilter("3gp","*.3gp")
               ,new FileChooser.ExtensionFilter("wma","*.wma")
               ,new FileChooser.ExtensionFilter("wav","*.wav")
               ,new FileChooser.ExtensionFilter("ogg","*.ogg")
               ,new FileChooser.ExtensionFilter("wmv","*.wmv"));
       //creer une instancde de Fichier
       comptt++;
      fileList=new ArrayList<>();
       fileList.add(fileChooser.showOpenDialog(stage));
       if(comptt>1 && fileList.get(0)!=null){
           if(mediaPlayer!=null){
               mediaPlayer.stop();
           }
           
           Media media2= new Media(fileList.get(0).getAbsoluteFile().toURI().toString());
          mediaPlayer= new MediaPlayer(media2);
       
       
       }
       
       if(fileList.get(0)!=null){
        stage.setTitle(fileList.get(0).getName()+" MC Media Player");   
        media = new Media(fileList.get(0).getAbsoluteFile().toURI().toString());
           
        // creer une instance de MediaPlayer
        mediaPlayer = new MediaPlayer(media);
        // jouer la video 
        mediaPlayer.play();

        // creer une instance de MediaView
        mediaView = new MediaView(mediaPlayer);
        DoubleBinding remainingHeight = sc1.heightProperty().subtract(bdp.getChildren().stream().mapToDouble(
                node -> node.getBoundsInParent().getHeight()).sum());
        sliderPart();
        mediaView.fitWidthProperty().bind(stage.widthProperty());
        mediaView.fitHeightProperty().bind(remainingHeight);
        mediaView.setPreserveRatio(true);
        mediaView.setSmooth(true);
        VBox hb=new VBox(mediaView);
        VBox hb2=new VBox(slider);
        hb2.setMaxWidth(900);
        hb2.setPadding(new Insets(0,20,15,20));
        hb.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.BOTTOM_CENTER);
        stp.getChildren().addAll(hb,hb2);
        StackPane.setAlignment(hb,Pos.TOP_CENTER);
        StackPane.setAlignment(hb2,Pos.BOTTOM_CENTER);

        bdp.setCenter(stp);
       }
    }
    public void chooseFiles(){
        FileChooser fChooser =new FileChooser();
        
        fChooser.setTitle("Choose one or multiple");
        fChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4","*.mp4")
       ,new FileChooser.ExtensionFilter("mp3","*.mp3"),
               new FileChooser.ExtensionFilter("mp4","*.mp4")
               ,new FileChooser.ExtensionFilter("flv","*.flv")
               ,new FileChooser.ExtensionFilter("3gp","*.3gp")
               ,new FileChooser.ExtensionFilter("wma","*.wma")
               ,new FileChooser.ExtensionFilter("wav","*.wav")
               ,new FileChooser.ExtensionFilter("ogg","*.ogg")
               ,new FileChooser.ExtensionFilter("wmv","*.wmv"));
        fileList=fChooser.showOpenMultipleDialog(stage);
        comptt++;
        if(fileList!=null){
        sizeFileList=fileList.size()-1;
        }
       if(comptt>1 && fileList!=null){
           if(mediaPlayer!=null){
               mediaPlayer.stop();
           }
           
           Media media2= new Media(fileList.get(sizeFileList).getAbsoluteFile().toURI().toString());
          mediaPlayer= new MediaPlayer(media2);
       
       
       }
        if(fileList!=null){
            for(File f:fileList){
                mediaList.add(new Media(f.getAbsoluteFile().toURI().toString()));
            }
            playMedia();
            stage.setTitle(fileList.get(currentMediaIndex).getName()+" MC Media Player");   

            
            
        }
    }
    
    public void playMedia(){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            }
            
            media = mediaList.get(currentMediaIndex);
            mediaPlayer=new MediaPlayer(media);
            mediaPlayer.setOnEndOfMedia(() -> playNextMedia());
            
            mediaPlayer.play();
            stage.setTitle(fileList.get(currentMediaIndex).getName()+" MC Media Player");
            mediaView = new MediaView(mediaPlayer);
            DoubleBinding remainingHeight = sc1.heightProperty().subtract(bdp.getChildren().stream().mapToDouble(
                node -> node.getBoundsInParent().getHeight()).sum());
            sliderPart();
            mediaView.fitWidthProperty().bind(stage.widthProperty());
            mediaView.fitHeightProperty().bind(remainingHeight);
            mediaView.setPreserveRatio(true);
            mediaView.setSmooth(true);    
           VBox hb=new VBox(mediaView);
            VBox hb2=new VBox(slider);
            hb2.setMaxWidth(900);
            hb2.setPadding(new Insets(0,20,15,20));  
            stp.getChildren().addAll(hb,hb2);
            bdp.setCenter(stp);


    }
    public void playNextMedia() {
        if (currentMediaIndex < mediaList.size() - 1) {
            currentMediaIndex++;
            playMedia();
        } else if(currentMediaIndex == mediaList.size() - 1){
        mediaPlayer.stop();
        currentMediaIndex++;
        System.out.println("Fin de la liste de lecture.");

        }else {
            mediaPlayer.stop();
            System.out.println("Fin de la liste de lecture.");
        }
            
    }
    public void playPreviewMedia() {
        if (currentMediaIndex >0) {
            currentMediaIndex--;
            playMedia();
        } else {
            
            System.out.println("Debut de la liste de lecture.");
        }
            
    }


    private void pauseMedia() {
        if(mediaPlayer!=null){
        if(btPlay.getGraphic().equals(imgPlay)){
            mediaPlayer.play();
            btPlay.setGraphic(imgPause);
        }
        if(mediaPlayer.getStatus().equals(mediaPlayer.getStatus().PLAYING)){
            mediaPlayer.pause();
            btPlay.setGraphic(imgPlay);
            
        }}
    }

    private void stopMedia() {
            if(mediaPlayer!=null){
            mediaPlayer.stop();
            btPlay.setGraphic(imgPlay);
            }
            
        
       
    }

    private void muteMedia() {
        if(mediaPlayer!=null){
        if(btMute.getGraphic().equals(imgMute)){
            mediaPlayer.setMute(true);
            btMute.setGraphic(imgUnmute);
        }else{
            mediaPlayer.setMute(false);
            btMute.setGraphic(imgMute);
            
        }
        }
        
    }
    
    public void playList(){
        int id=1;
        if(fileList!=null){
            for(File f:fileList){
                fsList.add(new FileSelected(id,f,f.getName(),f.getAbsoluteFile().toURI().toString()));
                
                id++;
            }
        }
        TableColumn<Media,String> colId= new TableColumn("Id");
        TableColumn<Media, String> colName= new TableColumn("Liste de Lecture");
        
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("nameFile"));
        tbView.getColumns().addAll(colId,colName);
        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tbView.setItems(fsList);
        bdp2.setCenter(tbView);
    
    }

    private void advance15() {
        if(mediaPlayer!=null){
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(15)));
        }
    }

    private void return15() {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(Duration.seconds(15)));
    }

    private void increaveV() {
        if(mediaPlayer!=null){
        mediaPlayer.setVolume(50);
        }
    }

    private void decreaseV() {
    }

    private void sliderPart() {
slider.setMin(0);
        slider.setMax(1);
        slider.setValue(0);

        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                if (!slider.isValueChanging()) {
                    slider.setValue(newValue.toSeconds() / media.getDuration().toSeconds());
                }
            }
        });

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (slider.isValueChanging()) {
                    mediaPlayer.seek(media.getDuration().multiply(newValue.doubleValue()));
                }
            }
        });
            }
   private MediaPlayer tableEvent() {
      FileSelected f;
      MediaPlayer mp = null;
        f =  (FileSelected) tbView.getSelectionModel().getSelectedItem();
      if(f!=null){
          Media m =new Media(f.getF().getAbsoluteFile().toURI().toString());
           mp= new MediaPlayer(m);
          
      }
      return mp;
    }
    
    
}
    