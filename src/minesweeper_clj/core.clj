(ns minesweeper-clj.core
  (:gen-class)
  (:require [clojure.math.combinatorics :as combo]))

(defn new-board
  "A new, empty 2d vector"
  ([rows cols]
   (vec (repeat cols (vec (repeat rows :empty)))))
  ([rows cols & mines] ))

(defn plant
  [board num-mines forbidden]
  (let [coords  (shuffle (combo/cartesian-product
                          (range (count board))
                          (range (count (get board 0)))))
        safe-coords (remove #(not (= forbidden %)) coords)
        mines (subvec (into [] safe-coords) 0 num-mines)]
    (reduce (fn [b m]
              (assoc-in b m :bomb))
            mines)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
