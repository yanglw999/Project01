package com.fx;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;
    public class ClockPane extends Pane {
        private int hour;
        private int minute;
        private int second;

        // Clock pane's width and height
        private double w = 800, h = 600;

        /** Construct a default clock with the current time */
        public ClockPane() {
            setCurrentTime();
        }

        /** Construct a click with specified hour, minute, and second */
        public ClockPane(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            paintClock();
        }

        /** Return hour */
        public int getHour() {
            return hour;
        }

        /** Set a new hour */
        public void setHour(int hour) {
            this.hour = hour;
            paintClock();
        }

        /** Return minute */
        public int getMinute() {
            return minute;
        }

        /** Set a new minute */
        public void setMinute(int minute) {
            this.minute = minute;
            paintClock();
        }

        /** Return second */
        public int getSecond() {
            return second;
        }

        /** Set a new second */
        public void setSecond(int second) {
            this.second = second;
            paintClock();
        }

        /** Return clock pane's width */
        public double getW() {
            return w;
        }

        /** Set clock pane's width */
        public void setW(double w) {
            this.w = w;
            paintClock();
        }

        /** Return clock pane's height */
        public double getH() {
            return h;
        }

        /** Set clock pane's heigt */
        public void setH(double h) {
            this.h = h;
            paintClock();
        }

        /* Set the current time for the clock */
        public void setCurrentTime() {
            // Construct a Calendar for the current date and time
            Calendar calendar = new GregorianCalendar();

            // Set current hour, minute and second
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);

            paintClock(); // Repaint the clock
        }

        /** Paint the clock */
        protected void paintClock() {
            // Initialize clock parameters
           // StackPane pane = new StackPane();
            double clockRadius = Math.min(w, h) * 0.8 * 0.5;
            double centerX = 00 + getW() / 2;// position the item in the center of pane
            double centerY = 00 + getH()/ 2;


            // Draw circle
            Circle circle = new Circle(centerX, centerY, clockRadius);
            //circle.centerYProperty().bind(pane.widthProperty().divide(2));
          //  circle.centerYProperty().bind(pane.heightProperty().divide(2));

            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

            // Draw second hand
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength *
                    Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength *
                    Math.cos(second * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);

            // Draw minute hand
            double mLength = clockRadius * 0.65;
            double xMinute = centerX + mLength *
                    Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength *
                    Math.cos(minute * (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, xMinute, minuteY);
            mLine.setStroke(Color.BLUE);

            // Draw hour hand
            double hLength = clockRadius * 0.4;
            double hourX = centerX + hLength *
                    Math.sin((hour % 12 + minute / 60.0 + second / 3600) * (2 * Math.PI / 12));
            double hourY = centerY - hLength *
                    Math.cos((hour % 12 + minute / 60.0 + second / 3600) * (2 * Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);

            getChildren().clear();
            getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }
    }

