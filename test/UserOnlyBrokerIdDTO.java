
/**
 * @Description:
 * @Author: yuzhengwu
 * @Date: 2021/6/16 11:36 上午
 * @Version: 1.0
 */
public class UserOnlyBrokerIdDTO {
    private Long userId;
    private Long brokerId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

    public UserOnlyBrokerIdDTO(Long userId, Long brokerId) {
        this.userId = userId;
        this.brokerId = brokerId;
    }
}
