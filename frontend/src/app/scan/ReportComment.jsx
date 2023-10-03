import React, { forwardRef, useEffect, useState } from 'react';
import ReportSection from './ReportSection';
import SendIcon from '@/assets/icons/Send.svg';
import axios from '@/api/index';
import { useSearchState } from './SearchContext';

function ReportCommentItem({ nickName, content }) {
  return (
    <div className="py-4 border-b border-black">
      <div className="text-xl font-bold">{nickName}</div>
      <div>{content}</div>
    </div>
  );
}

const CommentInput = forwardRef(function CommentInput({ placeholder }, ref) {
  return (
    <div className="flex items-center h-12 px-4 overflow-hidden border rounded-full border-outline">
      <input placeholder={placeholder} className="h-full grow outline-0" />
      <button className="relative flex items-center w-8 h-8 p-1 ml-1 rounded-full bg-primary">
        <SendIcon width="22" className="absolute right-[6px]" />
      </button>
    </div>
  );
});

function ReportComment() {
  const [comments, setComments] = useState([]);
  const { careaCode } = useSearchState();

  const fetchComments = async () => {
    const { data } = await axios.get(`/comment/${careaCode}`);
    setComments(data);
  };

  useEffect(() => {
    // fetchComments();
  }, []);
  return (
    <ReportSection title="코멘트" className="h-[60vh] ">
      <div className="overflow-auto h-[80%] scrollbar-hide mb-4">
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
        <ReportCommentItem nickName="닉네임 1" content="상권 정말 좋아요!" />
      </div>
      <CommentInput placeholder="댓글 추가" />
    </ReportSection>
  );
}

export default ReportComment;
