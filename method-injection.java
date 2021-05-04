class CarPaintingRobotWithMethodInjection {
   public PaintCar(aColor: string, aPaintGunTip: IPaintGunTip) {
     CheckNeitherNullNorUndefined(aPaintGunTip);
     aPaintGunTip.SprayCar(aColor);
   }
 }
