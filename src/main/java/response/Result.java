package response;

import com.windpo.registersystem.common.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 风之诗
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Boolean success;
    private String errMsg;
    private Integer errCode;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(true, null, null, data);
    }

    public static Result failure(String errMsg) {
        return new Result<>(false, errMsg, 5000, null);
    }

    public static Result failure(ErrorEnum error) {
        return new Result<>(false, error.getErrMsg(), error.getErrCode(), null);
    }
}
