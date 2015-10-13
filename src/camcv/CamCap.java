package camcv;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.core.Core;

import sun.rmi.runtime.Log;




public class CamCap extends javax.swing.JFrame 
{


    private DaemonThread myThread = null;
    int count = 0;
    
    // for Webcam
    VideoCapture webSource = null;

    Mat mat = new Mat();
    MatOfByte mem = new MatOfByte();

    String file_path="";

    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class DaemonThread implements Runnable {
    protected volatile boolean runnable = false;
    Image im;

    @Override
    public  void run() {
      synchronized(this){
      while(runnable){
      if(webSource.grab()){
      try{
                            // dapatkan gambar
      webSource.retrieve(mat);
                            //di-encode dari gambar ke memory
      Highgui.imencode(".bmp", mat, mem);
                            // array stream gambar
      im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                            // urutan gambar yang dibuffer
			    BufferedImage buff = (BufferedImage) im;
                            
			    Graphics g=jPanel1.getGraphics();

			    if (g.drawImage(buff, 0, 0, getWidth(), getHeight() -150 , 0, 0, buff.getWidth(), buff.getHeight(), null))
			    
			    if(runnable == false)
                            {
			    	System.out.println("Going to wait()");
			    	this.wait();
			    }
			 }
			 catch(Exception ex)
                         {
			    System.out.println("Error");
}}}}}
    
    ActionListener taskPerformer = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };


    
   
    
    
    public void getImage(){
        
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yy HH_mm_ss");
        Date date = new Date();
        String file_path = "D:\\capture_opencv\\"+dateFormat.format(date).toString()+".png";
        
        //String file_path = "D:\\capturesatu.png";
        //decode dari memory ke image
        //mat = Highgui.imdecode(mat, WIDTH);
        try{
            // tulis file sudah berhasil
            Highgui.imwrite(file_path,mat);
           System.out.println("Berhasiil");
           
        }catch(Exception e){
            System.err.println("Tak dapat menulis file: "+file_path);
          System.err.println("Because "+e);
       }
        return;
        
   }}

    /** Creates new form CamCap */
    public CamCap() {
        initComponents();
       
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        vidSource = new javax.swing.JComboBox();
        filePath = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capture");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        startBtn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        stopBtn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        stopBtn.setText("Stop");
        stopBtn.setEnabled(false);
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setAlignmentX(0.1F);
        jPanel2.setAlignmentY(0.1F);

        vidSource.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        vidSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "From WebCam", "From File" }));
        vidSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vidSourceActionPerformed(evt);
            }
        });

        filePath.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        filePath.setText("...");
        filePath.setEnabled(false);
        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Capture Method:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vidSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vidSource, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePath))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(53, 53, 53)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startBtn)
                    .addComponent(stopBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed

        
            
        if ( (startBtn.getText()).equals("Start") )
        {
            if (vidSource.getSelectedItem().equals("From WebCam"))
            {
                webSource =new VideoCapture(0);
            }
            else
                webSource =new VideoCapture(file_path);
            
            myThread = new DaemonThread();
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();

            startBtn.setEnabled(false);
            stopBtn.setEnabled(true);
            vidSource.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_startBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed

        if ( (stopBtn.getText()).equals("Stop") )
        {
            
            myThread.runnable = false;
            
            
            
            stopBtn.setEnabled(false);
            startBtn.setEnabled(true);
            vidSource.setEnabled(true);
            
            webSource.release();
        }
    }//GEN-LAST:event_stopBtnActionPerformed

    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("AVI","avi");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            file_path=chooser.getSelectedFile().getPath();
            startBtn.setEnabled(true);
        }
        else
            file_path="";
    }//GEN-LAST:event_filePathActionPerformed

    private void vidSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vidSourceActionPerformed
        // TODO add your handling code here:
        if(vidSource.getSelectedItem().equals("From File"))
        {
            filePath.setEnabled(true);
            startBtn.setEnabled(false);
        }
        else
        {
            filePath.setEnabled(false);
            startBtn.setEnabled(true);
        }
    }//GEN-LAST:event_vidSourceActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
            

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (myThread == null) {
        }
        else
             if (myThread.runnable)
             {
                myThread.runnable = false;
                webSource.release();
              }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
      

try {
    while (true) {
         myThread.getImage();
        Thread.sleep(4000);
    }
} catch (InterruptedException e) {
    e.printStackTrace();
} 
startBtn.setEnabled(false);
            stopBtn.setEnabled(true);
            vidSource.setEnabled(false);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	//System.loadLibrary("OpenCV");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                CamCap.setDefaultLookAndFeelDecorated(true);
                try
                {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                }
                catch (Exception ex)
                {
                        System.out.println("Failed loading L&F: ");
                        System.out.println(ex);
                        System.out.println("Loading default Look & Feel Manager!");
                }

                new CamCap().setVisible(true);
            }
            
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton filePath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JComboBox vidSource;
    // End of variables declaration//GEN-END:variables

}
