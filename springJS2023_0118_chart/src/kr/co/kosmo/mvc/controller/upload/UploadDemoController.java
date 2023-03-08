package kr.co.kosmo.mvc.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.kosmo.mvc.dao.UpBoardDAO;
import kr.co.kosmo.mvc.dao.UpBoardDAOInter;
import kr.co.kosmo.mvc.vo.PageSearchDTO;
import kr.co.kosmo.mvc.vo.UpBoardDTO;

@Controller
@RequestMapping(value = "/upload")
public class UploadDemoController {
    
	@Autowired
	private UpBoardDAOInter upBoardList;
	// -----------------------------------------------
	// Pageó���� ���� �Ӽ�
		private int nowPage = 1; // ���� ������ �� -> �޴� �������� �����Ǵ� ����
		private int nowBlock = 1; // ���� �� -> [][][][][] -> 1block�� 5��  �迭 ����
		private int totalRecord; // �� �Խù� �� .Dao�� ���� ����
		private int numPerPage = 10; // �� �������� ������ �Խù� ��
		private int pagePerBlock = 5; // �� ���� ������ ������ ��
		private int totalPage;  // ��ü ������ �� => totalRecord/numPerPage
		private int totalBlock; // ��ü ����
		private int beginPerPage; // �� �������� ���� �Խù��� index��
		private int endPerPage; // �� �������� ������ �Խù��� index��
	// --------------------------------------------------
		
	@GetMapping(value = "/upform")
	public String upform() {
		return "updemo/upform";
		
	}
	@PostMapping(value = "/uploadpro")
	public String uploadFile(Model m, UpBoardDTO dto, HttpServletRequest request) {
		System.out.println("sub :"+dto.getSub());
		
		String img_path = "resources\\imgfile";
		
		// request�� ������ �̹����� ��θ� �޾Ƽ� ���
		String r_path = request.getRealPath("/");
		System.out.println("r_path :"+r_path);
		// ���ε� �� �̹����� �̸��� �޾Ƽ� �̹����� ����
		// �̹��� �̸� Ȯ��
		String oriFn = dto.getMfile().getOriginalFilename();
		
		//  �̹��� ������ �� contentType Ȯ��
		long size = dto.getMfile().getSize();
		String contentType = dto.getMfile().getContentType();
		// contentType�� ����
		// application/vnd.ms-excel
		// application/pdf
		// text/plain
		// application/haansofhwp
		// image/jpag
		System.out.println("���� ũ�� :"+size);
		System.out.println("������ type : "+ contentType);
		
		// �޸𸮻�(�ӽ��������)�� ������ �츮�� ������ ��ο� ���� �ϰڴ�.
		// �̹����� ����� ��� �����
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(img_path).append("\\");
		path.append(oriFn);
		System.out.println("FullPath :"+path); 
		
		// �߻���(�̹����� ������ ���) File ��ü�� ����
		File f = new File(path.toString());
		
		// �ӽ� �޸𸮿� ��� �� ���ε��� ������ �� -> FileŬ������ ��η� ����
		try {
			dto.getMfile().transferTo(f);
			// �̹��� �̸��� db�� �����ϱ� ���ؼ� DTO ���� �缳��
			dto.setImgn(oriFn);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		
		}
		upBoardList.addUpBoard(dto);
		
		return "redirect:upboardList";
	}
	// search�ϰ�� post�ü� ������ method�� ���� ����
		@RequestMapping("/upboardListBack")
		public String upBoardList(Model model, String cPage) {
			// Map<String, Integer> map = new HashMap<String, Integer>();
			// map.put("begin", 1);
			// map.put("end", 10);
			// List<UpBoardDTO> list = upBoardList.getList(map);

			// --------------Page ó���ϱ�
			// �� �Խù� �� �������� => ������ TotalRecord :21
			totalRecord = upBoardList.getCnt();
			System.out.println("1. TotalRecord :" + totalRecord);
			// ��ü ������ ����غ��� => totalPage :2.1
			// double totalPage2 = totalRecord/(double)numPerPage;

			// �ø� => 2.1 => 3
			totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
			System.out.println("2. totalPage :" + totalPage);

			// totalBlock = totalPage/5;
			totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
			System.out.println("3. totalBlock :" + totalBlock);

			// ���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
			String s_page = cPage;
			if (s_page != null) {
				nowPage = Integer.parseInt(s_page);
			}
			System.out.println("4. nowPage :" + nowPage);

			// nowPage�� ������ SQL���� #{begin} , #{end} ����
			beginPerPage = (nowPage - 1) * numPerPage + 1;
			endPerPage = (beginPerPage - 1) + numPerPage;
			System.out.println("5. beginPerPage = " + beginPerPage);
			System.out.println("5. endPerPage = " + endPerPage);
			// ������ �����غ���
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("begin", beginPerPage);
			map.put("end", endPerPage);

			List<UpBoardDTO> list = upBoardList.getList(map);

			// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
			// view�� �����ؾ� ��.
			int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
			int endPage = startPage + pagePerBlock - 1;
			// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
			// totalPage�� ������ ���Խ�Ų��.
			if (endPage > totalPage) {
				endPage = totalPage;
			}

			System.out.println("6. startPage = " + startPage);
			System.out.println("6. endPage = " + endPage);

			// View�� forward�� ������ ������
			model.addAttribute("list", list);
			model.addAttribute("nowPage", nowPage);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("pagePerBlock", pagePerBlock); // ������ 5
			model.addAttribute("totalPage", totalPage);

			// --------------------------
			// model.addAttribute("totalRecord", totalRecord);
			// model.addAttribute("list", list);
			return "updemo/upboardList";
		}
	// Search�� ��� post �ü� ������ method�� ���� ���Ѵ�.
	@RequestMapping("/upboardList")
	public String upBoardList(Model model, String cPage,String searchType,String searchValue) {
		System.out.println("================Search");
		PageSearchDTO vo = new PageSearchDTO();
		vo.setSearchType(searchType);
		vo.setSearchValue(searchValue);
		System.out.println("searchType =>"+searchType);
		System.out.println("searchValue =>"+searchValue);
		// --------------Page ó���ϱ�
		// �� �Խù� �� �������� => ������ TotalRecord :21
		totalRecord = upBoardList.getCnt(vo);
		System.out.println("1. TotalRecord :" + totalRecord);
		// ��ü ������ ����غ��� => totalPage :2.1
		// double totalPage2 = totalRecord/(double)numPerPage;
		
		// �ø� => 2.1 => 3
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		System.out.println("2. totalPage :" + totalPage);

		// totalBlock = totalPage/5;
		totalBlock = (int) Math.ceil((double) totalPage / pagePerBlock);
		System.out.println("3. totalBlock :" + totalBlock);

		// ���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�. 1 ~~~~~~~ n
		String s_page = cPage;
		if (s_page != null) {
			nowPage = Integer.parseInt(s_page);
		}
		System.out.println("4. nowPage :" + nowPage);

		// nowPage�� ������ SQL���� #{begin} , #{end} ����
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;
		System.out.println("5. beginPerPage = " + beginPerPage);
		System.out.println("5. endPerPage = " + endPerPage);
		// ������ �����غ���
		//Map<String, Integer> map = new HashMap<String, Integer>();
		//map.put("begin", beginPerPage);
		//map.put("end", endPerPage);
		vo.setBegin(beginPerPage);
		vo.setEnd(endPerPage);

		List<UpBoardDTO> list = upBoardList.getList(vo);

		// ������ ��Ͼȿ� ������ �ݺ� ��Ű�� ���� startPage , endPage�� ���ؼ�
		// view�� �����ؾ� ��.
		int startPage = (int) ((nowPage - 1) / pagePerBlock) * pagePerBlock + 1;
		int endPage = startPage + pagePerBlock - 1;
		// endPage�� ������ ������ �츮�� ���� totalPage�� �̸��̶��
		// totalPage�� ������ ���Խ�Ų��.
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		System.out.println("6. startPage = " + startPage);
		System.out.println("6. endPage = " + endPage);

		// View�� forward�� ������ ������
		model.addAttribute("list", list);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("pagePerBlock", pagePerBlock); // ������ 5
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("searchType", vo.getSearchType());
		model.addAttribute("searchValue", vo.getSearchValue());
		// --------------------------
		model.addAttribute("totalRecord", totalRecord);
		// model.addAttribute("list", list);
		return "updemo/upboardList";
	}
}
