(ns highlight-peeler.highlight-test
  (:require [highlight-peeler.highlight :as sut]
            [clojure.test :as t]))

(t/deftest matching-books
  (t/testing "An exact book name is specified"
    (let [highlight {:book-title "The Three Bears"}]
      (t/is (= true (sut/book-named? "The Three Bears" highlight)))))

  (t/testing "A substring is specified"
    (let [highlight {:book-title "The Three Bears"}]
      (t/is (= true (sut/book-named? "Three Bears" highlight))))))
