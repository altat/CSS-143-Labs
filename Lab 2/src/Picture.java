class Picture {
      private Circle[] myCircles = new Circle[100];
      private int numCircles;

      private Square[] mySquares = new Square[100];
      private int numSquares;

      public void addCircle(Circle next) {
            myCircles[numCircles++] = next;
      }

      public void addSquare(Square next) {
            mySquares[numSquares++] = next;
      }

      public String toString() {
            String retVal = "";
            //need to loop over Circles first
            for (int i = 0; i < numCircles; i++) {
                  retVal += myCircles[i] + " ";
            }
            //then another loop over Squares
            for (int i = 0; i < numSquares; i++) {
                  retVal += mySquares[i] + " ";
            }
            //this approach is nonscalable!
            return retVal;
      }
}