/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mcMediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author RE COMPUTER
 */
public class McMediaPlayer extends Application{
    Stage stage= null;
    BorderPane bdp=new BorderPane();
    BorderPane bdp2=new BorderPane();
    TableView tbView = new TableView();
    TableView tbViewP = new TableView();
    
    Scene sc1;
    Scene sc2;
    Media media = null;
    MediaPlayer mediaPlayer = null;
    MediaView mediaView = null;
    
    FileChooser fileChooser = null;
    Button btStop = new Button();
    Button btMute = new Button();
    Button btPlay = new Button();
    Button btPlaylist = new Button();
    Button btNext= new Button();
    Button btPreview= new Button();
    Button btNext15= new Button();
    Button btPreview15= new Button();
    Button btIncreaseV= new Button();
    Button btDecreaseV= new Button();
    Button fullS = new Button();
    Button btMaxim = new Button();
    List <File> files= new ArrayList<>();
    List <File> filesP= new ArrayList<>();

    ObservableList<File> fileList;
        ObservableList<File> fileListP;

    Slider slider = new Slider();
    Slider sliderV=new Slider();
    ColorPicker colorPicker = new ColorPicker();
    ObservableList<FileSelected> fsList;
    ObservableList<FileSelected> fsListP;
    FileSelected fs=null;
    ObservableList<Media> mediaList;
    
    ImageView imgPause=new ImageView("/img/icons/pause.png");
    ImageView imgPlay=new ImageView("/img/icons/play.png");
    ImageView imgStop=new ImageView("/img/icons/stop.png");
    ImageView imgNext=new ImageView("/img/icons/next.png");
    ImageView imgPreview=new ImageView("/img/icons/preview.png");
    ImageView imgMute=new ImageView("/img/icons/mute.png");
    ImageView imgUnmute=new ImageView("/img/icons/volume.png");
    ImageView imgFullS=new ImageView("/img/icons/fullS.png");
    ImageView imgMinim=new ImageView("/img/icons/ExitFS.png");
    ImageView imgMaxim=new ImageView("/img/icons/maximized.png");
    ImageView imgVolUp=new ImageView("/img/icons/volumeUp.png");
    ImageView imgVolD=new ImageView("/img/icons/VolumeD.png");
    ImageView imgPlaylist=new ImageView("/img/icons/playlist.png");
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
    int idView=0;
    int idCP;
    boolean flagPlaylist=false;
    MenuBar mnBar1=new MenuBar();
    ToolBar tBar1=new ToolBar();
    MenuBar mnBar2=new MenuBar();
    ToolBar tBar2=new ToolBar();
    
    
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
        stage.setMinWidth(450);
        stage.setMinHeight(300);
        stage.setHeight(400);
        stage.setWidth(650);
        stage.getIcons().add(new ImageView("/img/logo_MC_Play.png").getImage());
        mediaList = FXCollections.observableArrayList();
        fileList = FXCollections.observableArrayList();
        fileListP = FXCollections.observableArrayList();

        tbView.prefWidthProperty().bind(stage.widthProperty().multiply(0.20));
        fsList=FXCollections.observableArrayList();
        currentMediaIndex = 0;
        sc1 = new Scene(bdp);
        sc2 = new Scene(bdp2);
        fsListP=FXCollections.observableArrayList();
        stage.setScene(sc2); 
        
        imgPause.setFitWidth(15);
        imgPause.setFitHeight(15);
        imgPlay.setFitWidth(15);
        imgPlay.setFitHeight(15);
        imgStop.setFitHeight(15);
        imgNext.setFitHeight(15);
        imgPreview.setFitHeight(15);
        imgPlaylist.setFitWidth(15);
        imgPlaylist.setFitHeight(15);
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
        imgMaxim.setFitHeight(15);
        imgMaxim.setFitWidth(15);
        imgMinim.setFitHeight(15);
        imgMinim.setFitWidth(15);
        
        btMaxim.setGraphic(imgMaxim);
        btPlay.setGraphic(imgPlay);
        btPlaylist.setGraphic(imgPlaylist);
        btStop.setGraphic(imgStop);
        btNext.setGraphic(imgNext);
        btNext15.setGraphic(imgNext30);
        btPreview.setGraphic(imgPreview);
        btMute.setGraphic(imgMute);
        fullS.setGraphic(imgFullS);
        btDecreaseV.setGraphic(imgVolD);
        btIncreaseV.setGraphic(imgVolUp);
        mnBar1=menuBar();
        mnBar2=menuBar();
        tBar1=toolBar();
        tBar2=toolBar();
        bdp.setStyle("-fx-background:#000");
        bdp2.setStyle("-fx-background-color:#000;-fx-border-color:#000;");
        tBar2.setStyle("-fx-border-color:#000;");
        bdp.setStyle("-fx-background-color:#000;-fx-border-color:#000;");
        tBar1.setStyle("-fx-border-color:#000;");
        bdp.setBottom(tBar1);
        bdp.setTop(mnBar1);
        bdp2.setBottom(tBar2);
        bdp2.setTop(mnBar2);
        bouton();
        playList();
             
        stage.show();
    }
    
    public  MenuBar menuBar(){
        
        
        MenuBar mnBar= new MenuBar();
        Menu mnMedia = new Menu("Media");
        Menu mnPlayback = new Menu("Playback");
        Menu mnAudio = new Menu("Audio");
        Menu mnVideo = new Menu("Video");
        Menu mnView = new Menu("View");
        
        
        MenuItem mniOpenF= new MenuItem("Open file");
        mniOpenF.setGraphic(mniimgOpenF);
        mniOpenF.setOnAction(e->{chooseFile();});
        MenuItem mniOpenMultiF= new MenuItem("Open Multipes files");
        mniOpenMultiF.setGraphic(mniimgOpenMF);
        mniOpenMultiF.setOnAction(e->{chooseFiles();});
        MenuItem mniQuit= new MenuItem("Quit");
        mniQuit.setGraphic(imgQuit);
        mniQuit.setOnAction(e->{stage.close();});
        MenuItem mniCreatePl= new MenuItem("Create palylist");
        mniCreatePl.setGraphic(mniimgCreateP);
        mniCreatePl.setOnAction((ActionEvent t) -> {
            createPlaylist();
        });
        MenuItem mniClearP=new MenuItem("Clear Playlist");
        mniClearP.setOnAction(e->{mediaPlayer.dispose(); fileList.clear();fsList.clear(); tbView.refresh();btPlay.setGraphic(imgPlay);});
        
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
        mniIncreaseV.setOnAction(e->{btIncreaseV.fire();});
        MenuItem mniDecreaseV= new MenuItem("Decrease volume");
        mniDecreaseV.setGraphic(mniimgVolD);
        mniDecreaseV.setOnAction(e->{btDecreaseV.fire();});
        MenuItem mniMute= new MenuItem("Mute");
        mniMute.setGraphic(mniimgMute);
        mniMute.setOnAction(e->{btMute.fire();});
        MenuItem mniFullS= new MenuItem("Full screen");
        mniFullS.setGraphic(mniimgFullS);
        mniFullS.setOnAction(e->{ if(!fileList.isEmpty()){
            if(!stage.isFullScreen()){
                stage.setFullScreen(true);
                
            }   
            }});
        MenuItem mniZoom= new MenuItem("Maximized");
        mniZoom.setGraphic(mniimgZoom);
        mniZoom.setOnAction(e->{btMaxim.fire();});
        
        MenuItem mniPL= new MenuItem("Playlist View/ Media View");
        mniPL.setGraphic(mniimgCreateP2);
        mniPL.setOnAction(e->{btPlaylist.fire();
            
        });
        MenuItem mniChangeColor= new MenuItem("Change Background Color");
        mniChangeColor.setOnAction(e->{changeBackgroundColor();
        });
        
        mnMedia.getItems().addAll(mniOpenF, mniOpenMultiF,mniCreatePl ,mniClearP,mniQuit );
        mnPlayback.getItems().addAll(mniTitle, mniPlay, mniStop, mniPreview,mniNext);
        mnAudio.getItems().addAll(mniIncreaseV, mniDecreaseV,mniMute);
        mnVideo.getItems().addAll(mniFullS,mniZoom);
        mnView.getItems().addAll(mniPL,mniChangeColor);
        
       mnBar.getMenus().addAll(mnMedia,mnPlayback,mnAudio,mnVideo,mnView);
       stage.maximizedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
           if(stage.isMaximized()){mniZoom.setText("Minimized");}else{mniZoom.setText("Maximized");}
        });
       
       return mnBar;
       
    }
    public ToolBar toolBar(){
        ToolBar tBar= new ToolBar();
        sliderV.setPrefSize(0.2,0.2);
        sliderV.setPadding(new Insets(1,30,1,0));
        sliderV.setOrientation(Orientation.VERTICAL);
        slider.setPrefWidth(stage.widthProperty().multiply(0.3).floatValue());
        Pane space=new Pane();
        HBox.setHgrow(space, javafx.scene.layout.Priority.ALWAYS);
    tBar.getItems().addAll(btPlay, btStop,btPreview,btNext
            ,btNext15,btIncreaseV,btDecreaseV, btMute,fullS,btMaxim,btPlaylist, slider,space,sliderV);
    
    
     return tBar;
    
    
    }
    void bouton() {
       // HBox hb = new HBox(10, btAddMedia,btPause, btStop, btMute);
       // hb.setPadding(new Insets(12));
        //bdp.setBottom(hb);
        toolBar();
        btPlay.setOnAction(e -> {
            if(!fileList.isEmpty()){
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
            if(!fileList.isEmpty()){
            if(!stage.isFullScreen()){
                stage.setFullScreen(true);
                
            }   
            }
        });
        
        btMaxim.setOnAction(e->{
            tBar2.setVisible(true);
            if(stage.isMaximized()){
                btMaxim.setGraphic(imgMaxim);
                stage.setMaximized(false);
                if(!fileList.isEmpty()){mediaView.fitHeightProperty().bind(stage.heightProperty().multiply(0.9));}
                stage.setHeight(400);
                stage.setWidth(650);
            }else{
                btMaxim.setGraphic(imgMinim);
                stage.setMaximized(true);
                if(!fileList.isEmpty()){mediaView.fitHeightProperty().bind(stage.heightProperty().multiply(0.9));}
                
            }
        });
        btPlaylist.setOnAction(e->{
            if(!flagPlaylist){
                tbView.prefWidthProperty().bind(stage.widthProperty());
                bdp.setCenter(tbView);
                stage.setScene(sc1);
                flagPlaylist=true;
                
                if(stage.isMaximized()){
                    stage.setMaximized(false);
                    stage.setMaximized(true);

                }else{
                    stage.setMaximized(true);
                    stage.setMaximized(false);
                }
               
            }else{
                tbView.prefWidthProperty().bind(stage.widthProperty().multiply(0.20));
                bdp2.setLeft(tbView);
                stage.setScene(sc2);
                flagPlaylist=false;
                if(stage.isMaximized()){
                    stage.setMaximized(false);
                    stage.setMaximized(true);

                }else{
                    stage.setMaximized(true);
                    stage.setMaximized(false);
                }
            }
        });
       stage.fullScreenProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) -> {
           if(t1){
           mnBar2.setVisible(!t1);
           tBar2.setVisible(!t1);
           mnBar2.setManaged(!t1);
           tbView.setVisible(!t1);
           tbView.setManaged(!t1);
           mediaView.fitHeightProperty().bind(stage.heightProperty());
           mediaView.fitWidthProperty().bind(stage.widthProperty());

           }else{                   
               mnBar2.setVisible(t);
           tBar2.setVisible(t);
           mnBar2.setManaged(t);
           tbView.setVisible(t);
           tbView.setManaged(t);
           mediaView.fitHeightProperty().bind(stage.heightProperty());
               mediaView.fitWidthProperty().bind(stage.widthProperty().multiply(0.80));
            }
        });
       
        
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
        files=fileChooser.showOpenMultipleDialog(stage);
        if(files!=null){fileList.addAll(files);}
        if(fileList!=null){
            if(files!=null){mediaList = FXCollections.observableArrayList();comptt++;currentMediaIndex=0;}
            for(File f:fileList){
                mediaList.add(new Media(f.getAbsoluteFile().toURI().toString()));
            }
            
            
            if(files!=null){
                playMedia();
            }
            files=null;
            
            playList();
            tbView.refresh();
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
        files=fChooser.showOpenMultipleDialog(stage);
        if(files!=null){fileList.addAll(files);}
        if(fileList!=null){
            if(files!=null){mediaList = FXCollections.observableArrayList();comptt++;currentMediaIndex=0;}
            for(File f:fileList){
                mediaList.add(new Media(f.getAbsoluteFile().toURI().toString()));
            }
            if(files!=null){
                playMedia();
            }
            
            files=null;
            playList();
            tbView.refresh();
        }
    }
    
    public void playMedia(){
            
            btPlay.setGraphic(imgPause);
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            for(Media m:mediaList){System.out.println(m);}
            }
            idView = tableEvent();
            if(idView!=(-1)){
            currentMediaIndex=idView-1; 
            idView=-1;
            media = mediaList.get(currentMediaIndex);
            }else{
            media = mediaList.get(currentMediaIndex);
            System.out.println(currentMediaIndex);
            }
           
            mediaPlayer=new MediaPlayer(media);
            mediaPlayer.setOnEndOfMedia(() -> playNextMedia());
            if(currentMediaIndex==fileList.size()-1){
                System.out.println(mediaPlayer.getStatus());
                
            }
            
            mediaPlayer.play();
            
            stage.setTitle(fileList.get(currentMediaIndex).getName()+" MC Media Player");
            mediaView = new MediaView(mediaPlayer);
           
            sliderPart();
            sliderVolume();
            
            mediaView.fitWidthProperty().bind(stage.widthProperty().multiply(0.80));
            mediaView.fitHeightProperty().bind(stage.heightProperty().multiply(0.91));
           
            mediaView.setPreserveRatio(true);
            mediaView.setSmooth(true); 
            mediaView.setVisible(true);
//            HBox hbm= new HBox(mediaView);
//            hbm.setAlignment(Pos.CENTER);
            bdp2.setRight(mediaView);
            

    }
    public void playNextMedia() {
         if(!fileList.isEmpty()){
             
            
            if (currentMediaIndex < mediaList.size() - 1) {
                currentMediaIndex++;
                playMedia();
            }else {
                    
                System.out.println("Fin de la liste de lecture.");
                }
           
            }
           
    }
    public void playPreviewMedia() {
        if(!fileList.isEmpty()){
            
        if (currentMediaIndex >0) {
            currentMediaIndex--;
            playMedia();
            if(stage.isFullScreen()){
            mediaView.fitHeightProperty().bind(stage.heightProperty());
            mediaView.fitWidthProperty().bind(stage.widthProperty());
            
            }
        } else {
            mediaPlayer.stop();
            mediaPlayer.play();
             
            System.out.println("Debut de la liste de lecture.");
        }
        }
    }
    


    private void pauseMedia() {
        mediaView.setVisible(true);
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
            mediaView.setVisible(false);
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
        //bdp2.setTop(mnBar);
        int id=1;
        fsList.clear();
            for(File f:fileList){
                fsList.add(new FileSelected(id,f,f.getName(),f.getAbsoluteFile().toURI().toString()));
                System.out.println("fichier enregsitrer");
                id++;
            }
       
        TableColumn<Media,String> colId= new TableColumn("Id");
        TableColumn<Media, String> colName= new TableColumn("Name");
        TableColumn<Media, String> colPath= new TableColumn("Path");
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("nameFile"));
        colPath.setCellValueFactory(new PropertyValueFactory<>("filePath"));
        colId.prefWidthProperty().bind(tbView.widthProperty().multiply(0.2));
        colName.prefWidthProperty().bind(tbView.widthProperty().multiply(0.35));
        colPath.prefWidthProperty().bind(tbView.widthProperty().multiply(0.45));
        tbView.getColumns().addAll(colId,colName,colPath);
        tbView.setItems(fsList);
        
        
        bdp2.setLeft(tbView);
        tbView.setOnMouseClicked(e->{if(!fileList.isEmpty()){playMedia();}});
    }
    private int tableEvent() {
        int idFileView=-1;
      FileSelected f;Media m = null;
        f = (FileSelected) tbView.getSelectionModel().getSelectedItem();
      if(f!=null){
         m =new Media(f.getF().getAbsoluteFile().toURI().toString());
         idFileView=f.getId();
         
      }
        tbView.getSelectionModel().clearSelection();
      return idFileView;
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
        double volume=sliderV.getValue();
        sliderV.setValue(Math.min(volume+0.2, 2));
    }

    private void decreaseV() {
        double volume=sliderV.getValue();
        sliderV.setValue(Math.max(volume-0.1, 0));
    }

    private void sliderPart() {
        slider.setMin(0);
        slider.setMax(1);
        slider.setValue(0);

        mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
            if (!slider.isValueChanging()) {
                slider.setValue(newValue.toSeconds() / media.getDuration().toSeconds());
            }
        });

        slider.valueProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (slider.isValueChanging()) {
                mediaPlayer.seek(media.getDuration().multiply(newValue.doubleValue()));
            }
        });
            }
    
    public void sliderVolume(){
        sliderV.setOrientation(Orientation.VERTICAL);
        sliderV.setMax(2);
        sliderV.setMin(0);
        sliderV.setValue(0.5);
        sliderV.setShowTickLabels(true);
        sliderV.setShowTickMarks(true);
        sliderV.setMajorTickUnit(0.1);
        sliderV.setBlockIncrement(0.5);
        mediaPlayer.volumeProperty().bind(sliderV.valueProperty());
        
    
    }
   
    
    
    private void changeBackgroundColor() {
       
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Choose a Background color");

        
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(stage);
      
        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);
        Label lChoix= new Label("Please choose a Color");
        Button btColor= new Button("Choose");
        btColor.setOnAction(e->{dialogStage.close();});
        Button btResetColor= new Button("Use Default Color");
        HBox hbB=new HBox( 10,btResetColor,btColor);
        hbB.setAlignment(Pos.CENTER);
        btResetColor.setOnAction(e->{
            colorPicker.setValue(Color.BLACK);
            dialogStage.close();
        });
        VBox vb = new VBox(20,lChoix, colorPicker,hbB);
        vb.setAlignment(Pos.CENTER);
        Scene dialogScene = new Scene(vb, 300, 200);

        dialogStage.setScene(dialogScene);
        dialogStage.showAndWait(); 
        String newValue=colorPicker.getValue().toString();
        
        bdp2.setStyle("-fx-background:#"+newValue.substring(2)+";-fx-border-color:#"+newValue.substring(2)); 
        tBar2.setStyle("-fx-border-color:#"+newValue.substring(2)); 
        bdp.setStyle("-fx-background:#"+newValue.substring(2)+";-fx-border-color:#"+newValue.substring(2)); 
        tBar1.setStyle("-fx-border-color:#"+newValue.substring(2)); 
        
    }
    
    public void createPlaylist(){
        Stage nPStage= new Stage();
        BorderPane bdp4 =new BorderPane();
        Scene nPScene =new Scene(bdp4);
        nPStage.setWidth(400);
        nPStage.setHeight(200);
        Button btAddP= new Button("Add");
        Button btRemoveP =new Button("remove");
        Button btCancelP= new Button("Cancel");
        Button btCreateP =new Button("Create");
        VBox vbB =new VBox(10,btAddP,btRemoveP,btCancelP,btCreateP);
        vbB.setAlignment(Pos.CENTER);
        
        btAddP.setOnAction(e->{
            FileChooser fPChooser =new FileChooser();
        
            fPChooser.setTitle("Choose one or multiple");
            fPChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("mp4","*.mp4")
           ,new FileChooser.ExtensionFilter("mp3","*.mp3"),
                   new FileChooser.ExtensionFilter("mp4","*.mp4")
                   ,new FileChooser.ExtensionFilter("flv","*.flv")
                   ,new FileChooser.ExtensionFilter("3gp","*.3gp")
                   ,new FileChooser.ExtensionFilter("wma","*.wma")
                   ,new FileChooser.ExtensionFilter("wav","*.wav")
                   ,new FileChooser.ExtensionFilter("ogg","*.ogg")
                   ,new FileChooser.ExtensionFilter("wmv","*.wmv"));
            filesP=fPChooser.showOpenMultipleDialog(nPStage);
            if(filesP!=null){fileListP.addAll(filesP);}
            if(idCP<1){
            if(!fileList.isEmpty()){
                idCP=fileList.size()+1;
            }else{
                idCP=1;
            }
            }
            if(filesP!=null){
            for(File f:filesP){
                fsListP.add(new FileSelected(idCP,f,f.getName(),f.getAbsoluteFile().toURI().toString()));
                System.out.println("fichier enregsitrer");
                idCP++;
            }
            }
        });
       
        
       
        TableColumn<Media,String> colId= new TableColumn("Id");
        TableColumn<Media, String> colName= new TableColumn("Name");
        TableColumn<Media, String> colPath= new TableColumn("Path");
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("nameFile"));
        colPath.setCellValueFactory(new PropertyValueFactory<>("filePath"));
        colId.prefWidthProperty().bind(tbViewP.widthProperty().multiply(0.15));
        colName.prefWidthProperty().bind(tbViewP.widthProperty().multiply(0.35));
        colPath.prefWidthProperty().bind(tbViewP.widthProperty().multiply(0.50));
        tbViewP.getColumns().addAll(colId,colName,colPath);
        tbViewP.setItems(fsListP);
        tbViewP.refresh();
        nPStage.setMinWidth(400);
        nPStage.setMaxHeight(400);
        tbViewP.prefWidthProperty().bind(nPStage.widthProperty().multiply(0.80));
        
        
        
        btRemoveP.setOnAction(g->{
                removeToP();
            });
        btCancelP.setOnAction(e->{
            fileListP.clear();
            fsListP.clear();
            nPStage.close();
            });
        tbViewP.setOnMouseClicked(e-> {
            fs =(FileSelected) tbViewP.getSelectionModel().getSelectedItem();
        });
        btCreateP.setOnAction(g->{
            if(!fsListP.isEmpty()){
            fsList.addAll(fsListP);
            mediaList = FXCollections.observableArrayList();
            comptt++;
            currentMediaIndex=0;
            
                mediaList = FXCollections.observableArrayList();
                comptt++;
                currentMediaIndex=0;
                fileList.addAll(fileListP);
                for(File f:fileList){
                    mediaList.add(new Media(f.getAbsoluteFile().toURI().toString()));
                    System.out.println("ya");
                }
                if(files!=null){
                    playMedia();
                }
            
                nPStage.close();
                tbView.refresh();
            }else{
                Alert a =new Alert(AlertType.ERROR);
                a.setContentText("Error, empty List, please add files.");
                a.initOwner(nPStage);
                a.initModality(Modality.WINDOW_MODAL);
                a.setWidth(500);
                a.setHeight(400);
                a.showAndWait();
            }
              
            });
        VBox vbT= new VBox(tbViewP);
        bdp4.setLeft(vbT);
        bdp4.setCenter(vbB);
        nPStage.setScene(nPScene);
        nPStage.initModality(Modality.WINDOW_MODAL);
        nPStage.initStyle(StageStyle.UTILITY);
        nPStage.initOwner(stage);
        nPStage.setTitle("Create a Playlist");
        nPStage.showAndWait();
        idCP=0;
        fsListP.clear();
    }

    private void removeToP() {
//                fileListP.remove(fs.getId()-1);
                fsListP.remove(fs);
                
                tbViewP.getSelectionModel().clearSelection();
                tbViewP.refresh();
    }

   
}
    