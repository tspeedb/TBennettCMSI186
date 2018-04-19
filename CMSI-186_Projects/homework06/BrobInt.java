       if (compare >= 0) {
            for (int i = 0; i < this.byteVersion.length; i++){
                if (i >= gint.byteVersion.length){
                     result = Integer.toString(this.byteVersion[i]) + result;
                 }else{
                     if ((this.byteVersion[i] - gint.byteVersion[i])  <  0){
                         this.byteVersion[i-1] -=10;
                         this.byteVersion[i]+=10;
                         result = Integer.toString((this.byteVersion[i] - gint.byteVersion[i])) + result;
                     }else{
                         result = Integer.toString((this.byteVersion[i] - gint.byteVersion[i])) + result;

                     }
                 }
            }
        }

        else {
            ;
             for (int i = 0; i < gint.byteVersion.length; i++){
                 if (i >= this.byteVersion.length){
                      result = Integer.toString(gint.byteVersion[i]) + result;
                  }else{
                      if ((gint.byteVersion[i] - this.byteVersion[i])  <  0){
                          gint.byteVersion[i-1] -=10;
                          gint.byteVersion[i]+=10;
                          result = Integer.toString((gint.byteVersion[i] - this.byteVersion[i])) + result;
                      }else{
                          result = Integer.toString((gint.byteVersion[i] - this.byteVersion[i])) + result;

                      }

                  }

             }
             result = "-" + result;
         }
