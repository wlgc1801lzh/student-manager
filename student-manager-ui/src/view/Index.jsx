import React, {useState} from 'react';
import {Button, Form, InfiniteScroll, Input, Space} from "antd-mobile";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import StudentList from "./StudentList";
import Top from "../component/Top";

const Index = () => {
    const navigate = useNavigate()
    const [form] = Form.useForm()

    //学生列表
    const [students, setStudents] = useState([])
    //是否可以上拉加载
    const [hasMore, setHasMore] = useState(false)
    //页码、容量
    const [page, setPage] = useState(0);
    let size = 10;

    //获取学生列表
    const doRequest = (value) => {
        axios.get("/api/student/list", {
            params: {...value, page, size}
        }).then(res => {
            //页码+1
            setPage(page + 1)
            //更新学生列表数据
            setStudents([...students, ...res.data.content])
            //是否有下一页数据
            setHasMore(!res.data.last)
        })
    }

    //提交搜索表单
    const onFinish = value => {
        //初始化
        setPage(0)
        setStudents([])
        //请求后端
        doRequest(value)
    }

    //加载更多数据
    async function loadMore() {
        const value = form.getFieldValue()
        await doRequest(value)
    }

    //添加学生信息
    const addClick = () => navigate("/student/add")

    return (
        <div>
            <Top title="首页"/>

            <Form layout='horizontal'
                  onFinish={onFinish}
                  form={form}
                  footer={
                      <Space>
                          <Button type='submit' color='primary'>查询</Button>
                          <Button color='success' onClick={addClick}>添加</Button>
                      </Space>
                  }>
                <Form.Item name='collegeName' label='学院'>
                    <Input placeholder='请输入学院' clearable/>
                </Form.Item>
                <Form.Item name='className' label='班级'>
                    <Input placeholder='请输入班级' clearable/>
                </Form.Item>
                <Form.Item name='studentId' label='学号'>
                    <Input placeholder='请输入学号' clearable/>
                </Form.Item>
                <Form.Item name='realName' label='姓名'>
                    <Input placeholder='请输入姓名' clearable/>
                </Form.Item>
            </Form>

            <StudentList list={students}/>
            <InfiniteScroll loadMore={loadMore} hasMore={hasMore}/>
        </div>
    );
};

export default Index;
