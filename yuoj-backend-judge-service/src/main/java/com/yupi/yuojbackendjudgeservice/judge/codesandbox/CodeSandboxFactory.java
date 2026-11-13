package com.yupi.yuojbackendjudgeservice.judge.codesandbox;

import com.yupi.yuojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yupi.yuojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yupi.yuojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
@Component
public class CodeSandboxFactory {

    @Resource
    private ExampleCodeSandbox exampleCodeSandbox;

    @Resource
    private RemoteCodeSandbox remoteCodeSandbox;

    @Resource
    private ThirdPartyCodeSandbox thirdPartyCodeSandbox;

    /**
     * 创建代码沙箱示例
     *
     * @param type 沙箱类型
     * @return
     */
    public CodeSandbox newInstance(String type) {
        switch (type) {
            case "remote":
                return remoteCodeSandbox;
            case "thirdParty":
                return thirdPartyCodeSandbox;
            default:
                return exampleCodeSandbox;
        }
    }
}
