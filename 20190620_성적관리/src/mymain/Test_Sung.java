package mymain;

import java.util.List;

import dao.SungTBDao;
import vo.SungVo;

public class Test_Sung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DB  Insert
		
		//�߰��� ������ ����
		SungVo vo = new SungVo();
		vo.setName("�׽���");
		vo.setKor(100);
		vo.setEng(100);
		vo.setMat(1000);
		
		//�߰�
		int res = SungTBDao.getInstance().insert(vo);
		if(res==1)
			System.out.println("--success insert--");
		else
			System.out.println("--fail insert--");
		
				
		
        //DB���� ��ȸ
        List<SungVo> list = SungTBDao.getInstance().selectList();
        
        for(SungVo vo1 : list) {
        	
        	System.out.printf("%d-%s\n", vo1.getNo(), vo1.getName() );
        	
        }
        
        
		
	}

}
