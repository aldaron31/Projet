����   7 0
      javafx/scene/canvas/Canvas <init> (DD)V
  	 
   (fr/insa/gonzalvo/projet/gui/DessinCanvas getGraphicsContext2D '()Ljavafx/scene/canvas/GraphicsContext;	      javafx/scene/paint/Color RED Ljavafx/scene/paint/Color;
      #javafx/scene/canvas/GraphicsContext setFill (Ljavafx/scene/paint/Paint;)V
     getWidth ()D
     	getHeight
  ! " # fillRect (DDDD)V Code LineNumberTable LocalVariableTable this *Lfr/insa/gonzalvo/projet/gui/DessinCanvas; w D h context %Ljavafx/scene/canvas/GraphicsContext; 
SourceFile DessinCanvas.java !            $   | 	    $*')� *� :� � *� *� �  �    %              #  &   *    $ ' (     $ ) *    $ + *    , -   .    /