package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/banners")
@Validated
public class BannerController {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerService bannerService;

    @GetMapping("/page")
    public PageResponseVO<BannerDO> page(@RequestParam(required = false, defaultValue = "0")
                               @Min(value = 0) Integer page,
                                         @RequestParam(required = false, defaultValue = "20")
                               @Min(value = 0) @Max(value = 30) Integer count) {

        Page<BannerDO> bannerDOPage = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(bannerDOPage, null);
        return new PageResponseVO<BannerDO>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());

    }

    @GetMapping("/{id}")
    public BannerWithItemsBO getBanner(@PathVariable @Positive Long id) {
        return bannerService.getWithItems(id);
    }

    @PutMapping("/{id}")
    public UpdatedVO<BannerDO> update(@PathVariable @Positive Long id,
                                      @RequestBody @Validated BannerDTO bannerDTO) {

        bannerService.update(bannerDTO, id);
        return new UpdatedVO<BannerDO>();
    }

    @DeleteMapping("/{id}")
    public DeletedVO<BannerDO> delete(@PathVariable @Positive Long id) {
        bannerService.delete(id);
        return new DeletedVO<BannerDO>();
    }
}
