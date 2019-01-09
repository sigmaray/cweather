(ns cweather.core (:gen-class)
  (:use cweather.api)
  (:import [javax.swing JFrame JLabel JTextField JButton]
          [java.awt.event ActionListener]
          [java.awt GridLayout])
)

; (defn foo
;   "I don't do a whole lot."
;   [x]
;   (println x "Hello, World!"))

; (defn -main []
;    (println "I'm a little teapot!"))

; (defn -main []
;   (prn "Trying to get location... It will take some time")
;   (let [location "Madrid"]
;     (clojure.pprint/pprint [location (get-temp location)])))

(defn -main []
  (let [frame (new JFrame "Celsius Converter")
        temp-text (new JTextField)
        celsius-label (new JLabel "Celsius")
        convert-button (new JButton "Convert")
        fahrenheit-label (new JLabel "Fahrenheit")]
      (. convert-button
          (addActionListener
             (proxy [ActionListener] []
                  (actionPerformed [evt]
                      (let [c (Double/parseDouble (. temp-text (getText)))]
                        (. fahrenheit-label
                           (setText (str (+ 32 (* 1.8 c)) " Fahrenheit"))))))))
      (doto frame 
                  ;(.setDefaultCloseOperation (JFrame/EXIT_ON_CLOSE)) ;uncomment this line to quit app on frame close
                  (.setLayout (new GridLayout 2 2 3 3))
                  (.add temp-text)
                  (.add celsius-label)
                  (.add convert-button)
                  (.add fahrenheit-label)
                  (.setSize 300 80)
                  (.setVisible true)))
)
