package esprit.DevUp.FoRest;

import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.IOException;


@SpringBootApplication
@EnableScheduling
public class FoRestApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(FoRestApplication.class, args);
		System.out.println("FOREST");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		CascadeClassifier animal_cascade = new CascadeClassifier("C:/OpenCv3.4.3/opencv/sources/data/haarcascades/haarcascade_frontalface_alt.xml");

	}
}





